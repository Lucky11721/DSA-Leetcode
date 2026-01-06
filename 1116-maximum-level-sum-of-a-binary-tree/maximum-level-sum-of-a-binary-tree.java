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
    public int maxLevelSum(TreeNode root) {
        int sum = Integer.MIN_VALUE;
        int level = 1;
        int ans =0;
       
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(que.isEmpty() == false){
            int size = que.size();
             int currSum =0;
           

            while(size > 0){
                 TreeNode node = que.remove();
                 currSum += node.val;
                 if(node.left != null) que.add(node.left);
                 if(node.right != null) que.add(node.right);
                 size--;
            } 
            System.out.println(currSum + " " + " " + level + " " + sum);
            
            if(currSum > sum){
                sum = currSum;
                ans = level;
            }
             level++;

        }

        return ans;

    }
}