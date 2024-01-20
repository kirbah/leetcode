/*
 * @lc app=leetcode id=138 lang=java
 *
 * [138] Copy List with Random Pointer
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

import java.util.HashMap;

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return head;

        // Creat copies in map
        Map<Node, Node> map = new HashMap<>();
        Node current = head;
        while (current != null) {
            map.put(current, new Node(current.val));
            current = current.next;
        }

        // Update pointers to new nodes
        current = head;
        while (current != null) {
            map.get(current).next = map.get(current.next);
            map.get(current).random = map.get(current.random);
            current = current.next;
        }

        return map.get(head);
    }

    public Node copyRandomList_NoHash(Node head) {
        if (head == null) return head;

        Node current = head;
        // Insert copy of each node on the 2x places inside initial list
        while (current != null) {
            Node copy = new Node(current.val);
            copy.next = current.next;
            current.next = copy;
            current = copy.next;
        }
        Node res = head.next;

        // Point random in final list to copies located on 2nd places
        current = head;
        while (current != null && current.next != null) {
            current.next.random = current.random != null ? current.random.next : null;
            current = current.next.next;
        }

        // Restore the original list pointers 
        // and set proper next pointer in the new list
        current = head;
        while (current != null && current.next != null) {
            Node copyNode = current.next;
            Node nextOriginalNode = current.next.next;
            copyNode.next = nextOriginalNode != null ? nextOriginalNode.next : null;
            current.next = nextOriginalNode;
            current = nextOriginalNode;
        }

        return res;
    }
}
// @lc code=end

