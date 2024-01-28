/*
 * @lc app=leetcode id=230 lang=java
 *
 * [230] Kth Smallest Element in a BST
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;
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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        visitNodes(root, list);
        return list.get(k - 1);
    }

    private void visitNodes(TreeNode node, List<Integer> list) {
        if (node == null) return;

        visitNodes(node.left, list);
        list.add(node.val);
        visitNodes(node.right, list);
    }

    public int kthSmallest_dfs(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.add(node);
                node = node.left;
            }
            node = stack.pop();
            if (--k == 0) return node.val;
            node = node.right;
        }
        return 0;
    }
}
// @lc code=end

