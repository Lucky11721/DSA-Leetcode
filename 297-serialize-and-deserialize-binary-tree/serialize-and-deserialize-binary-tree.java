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

    // Encodes a tree to a single string.
 
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper1(root, sb);
        return sb.toString();
    }

    private void helper1(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("N,");
            return;
        }
        sb.append(root.val).append(",");
        helper1(root.left, sb);
        helper1(root.right, sb);
    }
 int index;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        index = 0;
        return helper2(arr );
    }
     // DFS to rebuild tree
    private TreeNode helper2(String[] arr ) {
        if (index >= arr.length || arr[index].equals("N")) {
            index++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(arr[index]));
        index++;
        node.left = helper2(arr);
        node.right = helper2(arr);
        return node;
    }
    }


// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));