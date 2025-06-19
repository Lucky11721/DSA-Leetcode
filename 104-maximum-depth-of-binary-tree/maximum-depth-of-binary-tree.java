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
    public int maxDepth(TreeNode root) {
       int ans = level(root , 0);

       return ans;
    }

    public int level(TreeNode root , int count){
        if(root == null) return 0;

        count = 1+ Math.max(level(root.left , count)  ,level(root.right , count));

        return count;
    }
}