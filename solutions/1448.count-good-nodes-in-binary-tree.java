/*
 * @lc app=leetcode id=1448 lang=java
 *
 * [1448] Count Good Nodes in Binary Tree
 */

// @lc code=start
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
    private int goodNodesCounter = 0;

    public int goodNodes(TreeNode root) {
        checkNodes(root.val, root);
        return goodNodesCounter;
    }

    private void checkNodes(int maximum, TreeNode node) {
        if (node == null) return;

        if (node.val >= maximum) {
            goodNodesCounter++;
        }

        int nextMax = Math.max(maximum, node.val);
        checkNodes(nextMax, node.left);
        checkNodes(nextMax, node.right);
    }
}
// @lc code=end

