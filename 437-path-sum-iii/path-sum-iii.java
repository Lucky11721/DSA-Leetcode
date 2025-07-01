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
        int rootsum = sum(root , targetSum);
        int left = pathSum(root.left , targetSum);
        int right  = pathSum(root.right , targetSum);

        return rootsum + left + right;
    }
    public int sum(TreeNode root , long k){
        if(root == null) return 0;
        int count = 0;
        if(root.val == k) count++;
        int leftsum = sum(root.left , k - root.val);
        int rightsum = sum(root.right , k - root.val);

        return count  + leftsum + rightsum;
    }
}