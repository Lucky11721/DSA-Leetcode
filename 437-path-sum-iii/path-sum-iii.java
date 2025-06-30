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
    
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;

        
        int rootSum =sum(root , targetSum);

       int leftsum =  pathSum(root.left , targetSum);
        int rightsum = pathSum(root.right , targetSum);
        return rootSum + leftsum + rightsum;

    }

    public int sum(TreeNode root , long k){
        if(root == null) return 0;
        int count = 0;
        if(k == root.val) count++;

        int leftcount = sum(root.left , k - root.val);
       int rightcount =  sum(root.right , k - root.val);

        return count + leftcount + rightcount;
    }
}