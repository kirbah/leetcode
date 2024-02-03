/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        return process(0, 0, preorder.length - 1, preorder, inOrderMap);
    }

    private TreeNode process(int preorderIndex, int inOrderStart, int inOrderEnd, int[] preorder, Map<Integer, Integer> inOrderMap) {
        int rootValue = preorder[preorderIndex];
        TreeNode root = new TreeNode(rootValue);
        int inOrderIndex = inOrderMap.get(rootValue);

        if (inOrderIndex > inOrderStart) {
            // Next node from preorder[] is the next root for the left subtree
            root.left = process(preorderIndex + 1, inOrderStart, inOrderIndex - 1, preorder, inOrderMap);
        }
        if (inOrderIndex < inOrderEnd) {
            // inOrderIndex - inOrderStart = number of nodes that will be used to build the left part of the tree
            // the next node from preorder[] will be the next root to start the right part of the tree
            root.right = process(preorderIndex + (inOrderIndex - inOrderStart) + 1, inOrderIndex + 1, inOrderEnd, preorder, inOrderMap);
        }
        return root;
    }
}
// @lc code=end

