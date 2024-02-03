/*
 * @lc app=leetcode id=124 lang=java
 *
 * [124] Binary Tree Maximum Path Sum
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

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxSumRecursive(root);
        return maxSum;
    }

    public int maxSumRecursive(TreeNode root) {
        if (root == null) return 0;

        int leftSum = Math.max(0, maxSumRecursive(root.left));
        int rightSum = Math.max(0, maxSumRecursive(root.right));

        maxSum = Math.max(maxSum, leftSum + root.val + rightSum);
        return root.val + Math.max(leftSum, rightSum);
    }
}
// @lc code=end

