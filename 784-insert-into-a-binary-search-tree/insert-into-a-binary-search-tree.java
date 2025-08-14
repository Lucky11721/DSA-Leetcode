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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
         TreeNode leaf = new TreeNode(val);
         helper(root , leaf);
         return root;
    }
    public void helper(TreeNode root , TreeNode leaf){
        if(root.val > leaf.val && root.left == null){
            root.left = leaf;
            return;
        }
        if(root.val < leaf.val && root.right == null){
            root.right = leaf;
            return;
        }
        if(root.val > leaf.val && root.left != null){
            helper(root.left , leaf);
        }
        if(root.val < leaf.val && root.right != null){
            helper(root.right , leaf);
        }
    }
}