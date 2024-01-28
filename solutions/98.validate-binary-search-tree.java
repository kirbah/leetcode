/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
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
    public boolean isValidBST(TreeNode root) {
        return isValidSubtree(root, null, null);
    }

    private boolean isValidSubtree(TreeNode node, Integer minBoundary, Integer maxBoundary) {
        if (node == null) return true;

        if ((maxBoundary != null && node.val >= maxBoundary)
         || (minBoundary != null && node.val <= minBoundary)) {
            return false;
        }

        return isValidSubtree(node.left, minBoundary, node.val) && isValidSubtree(node.right, node.val, maxBoundary);
    }
}
// @lc code=end

