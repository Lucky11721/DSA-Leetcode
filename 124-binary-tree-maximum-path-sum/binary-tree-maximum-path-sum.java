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
    int ans;
    public int maxPathSum(TreeNode root) {
        ans = root.val;
        helper(root);
        return ans;
    }
    public int helper(TreeNode root){
        if(root == null) return 0;

        int left_sum = helper(root.left);
        if(left_sum < 0) left_sum = 0;
        int right_sum = helper(root.right);
        if(right_sum < 0) right_sum = 0;
       
       ans = Math.max(ans , left_sum + root.val + right_sum);

       return root.val + Math.max(left_sum , right_sum);
    }
    
}