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
        int leftheight = height(root.left);
        int rightheight = height(root.right);

        if(leftheight - rightheight > 1 ||leftheight - rightheight < -1 ){
            return false;
        }
        boolean lst = isBalanced(root.left);
        if(lst == false) return false;

        boolean rst = isBalanced(root.right);
        if(rst == false) return false;
        return true;
    }
     public int height(TreeNode root){
        if(root == null) return 0;

        return 1 + Math.max(height(root.left) , height(root.right));
     }

}