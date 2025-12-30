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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true; 
        int leftlevel = level(root.left);
        int rightlevel = level(root.right);
        if(leftlevel - rightlevel >1  ||leftlevel - rightlevel < -1 ) return false;

        return isBalanced(root.left) && isBalanced(root.right);


    }

    public int level(TreeNode root){
        if(root == null) return 0;

        return 1 + Math.max(level(root.left) , level(root.right));
    }
}