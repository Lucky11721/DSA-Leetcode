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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return dfs(root ,target);
    }
    public TreeNode dfs(TreeNode root , int k){
        if(root == null) return null;

        root.left = dfs(root.left ,k);
        root.right = dfs(root.right , k);
        if(root.val == k){
            if(root.left == null && root.right == null){
                return null;
            }
        }
        return root;
    }
}