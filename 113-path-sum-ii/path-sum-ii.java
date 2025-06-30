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
    List<List<Integer>> ans;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        sum(root , targetSum , arr);
        return ans;
    }
    public void sum(TreeNode root , int k , List<Integer> arr){
        if(root == null ) return;
        arr.add(root.val);
        if(root.left == null && root.right == null){
            if(k == root.val){
               ans.add(new ArrayList<>(arr));
            }
        }
        sum(root.left , k - root.val , arr);
        sum(root.right , k - root.val , arr);

        arr.remove(arr.size() - 1); // backtrack
    }
}