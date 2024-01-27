/*
 * @lc app=leetcode id=100 lang=java
 *
 * [100] Same Tree
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q != null && p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }

    public boolean isSameTree_dfs(TreeNode p, TreeNode q) {
        Stack<List<TreeNode>> stack = new Stack<>();
        stack.push(Arrays.asList(p, q));

        while (!stack.empty()) {
            List<TreeNode> elements = stack.pop();
            TreeNode nodeP = elements.get(0);
            TreeNode nodeQ = elements.get(1);

            if (nodeP != null && nodeQ != null) {
                if (nodeP.val != nodeQ.val) {
                    return false;
                }
                stack.push(Arrays.asList(nodeP.left, nodeQ.left));
                stack.push(Arrays.asList(nodeP.right, nodeQ.right));
            } else if (nodeP != null || nodeQ != null) {
                // One of the nodes is null, but not both
                return false;
            }
        }

        return true;
    }
}
// @lc code=end

