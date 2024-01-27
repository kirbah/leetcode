/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            List<Integer> line = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.pollFirst();
                if (node != null) {
                    line.add(node.val);
                    queue.addLast(node.left);
                    queue.addLast(node.right);
                }
            }
            if (!line.isEmpty()) {
                result.add(line);
            }
        }
        return result;
    }
}
// @lc code=end

