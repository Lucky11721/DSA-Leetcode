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
    public int sumRootToLeaf(TreeNode root) {
        int[] value = new int[32];
        return helper(root , 0);
    }

    public int helper(TreeNode root  , int ans){
        if(root == null){
           return 0;
        }

        ans = (2*ans) + root.val;

        if(root.left == null && root.right == null) return ans;


        return helper(root.left , ans) + helper(root.right ,ans);


    }
}