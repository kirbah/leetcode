/*
 * @lc app=leetcode id=110 lang=java
 *
 * [110] Balanced Binary Tree
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

    private boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        checkDepth(root);
        return isBalanced;
    }

    private int checkDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = checkDepth(node.left);
        int right = checkDepth(node.right);
        isBalanced = isBalanced && Math.abs(left - right) < 2;

        return Math.max(left, right) + 1;
    }
}
// @lc code=end

