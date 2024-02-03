/*
 * @lc app=leetcode id=297 lang=java
 *
 * [297] Serialize and Deserialize Binary Tree
 */

// @lc code=start


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private static final String NULL = "N";
    private static final String DELIMITER = ",";
    private String[] tokens;
    private int index;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeDFS(root, sb);
        return sb.toString();
    }

    public void serializeDFS(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NULL).append(DELIMITER);
            return;
        }

        sb.append(node.val).append(DELIMITER);
        serializeDFS(node.left, sb);
        serializeDFS(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        tokens = data.split(DELIMITER);
        index = 0;
        return deserializeDFS();
    }

    public TreeNode deserializeDFS() {
        String token = tokens[index++];
        if (NULL.equals(token)) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(token));
        node.left = deserializeDFS();
        node.right = deserializeDFS();
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end

