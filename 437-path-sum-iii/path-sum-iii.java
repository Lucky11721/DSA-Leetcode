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
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;

        
        sum(root , targetSum);

        pathSum(root.left , targetSum);
        pathSum(root.right , targetSum);
        return count;

    }

    public void sum(TreeNode root , long k){
        if(root == null) return;

        if(k == root.val) count++;

        sum(root.left , k - root.val);
        sum(root.right , k - root.val);


    }
}