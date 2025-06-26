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
      
    return check(p,q);
    }

    public boolean check(TreeNode a , TreeNode b){
        if(a == null && b == null) return true;
        if(a == null || b == null) return false;
       if(a.val != b.val){
            return false;
       }
     
      
        boolean  left =  check(a.left , b.left);

        
        boolean   right = check(a.right , b.right);
    return left && right;
    }

}