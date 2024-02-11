/*
 * @lc app=leetcode id=133 lang=java
 *
 * [133] Clone Graph
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {

    Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (map.containsKey(node)) {
            return map.get(node);
        }

        Node cloned = new Node(node.val, new ArrayList<>(node.neighbors.size()));
        map.put(node, cloned);

        for(Node neighbor : node.neighbors) {
            cloned.neighbors.add(cloneGraph(neighbor));
        }

        return cloned;
    }

    public Node cloneGraph_bfs(Node node) {
        if (node == null) return null;

        Stack<Node> stack = new Stack<>();
        stack.push(node);

        Node cloned = new Node(node.val, new ArrayList<>(node.neighbors.size()));
        map.put(node, cloned);

        while (!stack.isEmpty()) {
            Node parent = stack.pop();
            for(Node current : parent.neighbors) {
                if (!map.containsKey(current)) {
                    map.put(current, new Node(current.val, new ArrayList<>(current.neighbors.size())));
                    stack.push(current);
                }
                map.get(parent).neighbors.add(map.get(current));
            }
        }

        return map.get(node);
    }
}
// @lc code=end

