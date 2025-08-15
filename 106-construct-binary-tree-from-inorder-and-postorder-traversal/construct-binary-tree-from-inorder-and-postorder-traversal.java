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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
       return helper(postorder , inorder , 0 , n-1 , 0 , n-1);
    }
    public TreeNode helper(int[] post , int[] in , int postlow , int posthigh , int inlow , int inhigh){
        if(postlow > posthigh || inlow > inhigh) return null;

        TreeNode root = new TreeNode(post[posthigh]);
        int root_index = 0;
        for(int i = 0; i <= inhigh  ; i++){
            if(root.val == in[i]){
                root_index = i;
                break;
            }
        }
        int lst_size = root_index - inlow;

        root.left = helper(post , in , postlow , postlow + lst_size -1 , inlow , root_index-1);
        root.right = helper(post , in , postlow + lst_size , posthigh -1 , root_index+1 , inhigh);
        return root;
    }
}