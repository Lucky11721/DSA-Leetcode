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
    public int rangeSumBST(TreeNode root, int low, int high) {
       int ans = rangesum(root , low , high);

       return ans + low + high;
    }

    public int rangesum(TreeNode root, int low, int high){
        if(root == null) return 0;
        int sum = 0 ;
        if(root.val > low && root.val < high){
          sum = sum + root.val;
        }

        int leftsum = 0;

        if(root.val > low){
            leftsum += rangesum(root.left , low , high); 
        }
        int rightsum  = 0;
        if(root.val < high){
            rightsum += rangesum(root.right , low , high); 
        }

        return sum  + leftsum + rightsum;

    }
}