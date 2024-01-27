/*
 * @lc app=leetcode id=104 lang=java
 *
 * [104] Maximum Depth of Binary Tree
 */

// @lc code=start

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // Recursive solution
    public int maxDepth_rec(TreeNode root) {
        if (root == null) return 0;

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    // Breadth-First Search (BFS) solution
    public int maxDepth_bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            level++;
        }
        return level;
    }

    // Iterative Depth-First Search (DFS)
    public int maxDepth(TreeNode root) {
        Stack<NodeWithDepth> stack = new Stack<>();
        stack.push(new NodeWithDepth(root, 1));
        int maxDepth = 0;

        while (!stack.isEmpty()) {
            NodeWithDepth node = stack.pop();
            if (node.node != null) {
                maxDepth = Math.max(maxDepth, node.depth);
                stack.push(new NodeWithDepth(node.node.right, node.depth + 1));
                stack.push(new NodeWithDepth(node.node.left, node.depth + 1));
            }
        }

        return maxDepth;
    }

    class NodeWithDepth {
        TreeNode node;
        int depth;

        public NodeWithDepth(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}
// @lc code=end

