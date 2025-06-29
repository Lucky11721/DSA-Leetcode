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
     return construct(inorder , postorder , 0 , n-1 , 0 , n-1);

    }
    public TreeNode construct(int[] in , int[] post , int postlow , int posthigh , int inlow , int inhigh){
        
         if(postlow > posthigh || inlow > inhigh){
            return null;
         }
         TreeNode root = new TreeNode(post[posthigh]);
         int root_index = 0;
         for(int i = 0 ; i < in.length ; i++){
            if(in[i] == root.val){
               root_index = i;
               break;
            }
         }
         int lst_size = root_index - inlow;
         root.left = construct(in , post , postlow, postlow + lst_size -1 , inlow , root_index-1 );
         
         root.right = construct(in , post , postlow + lst_size , posthigh -1 , root_index +1 , inhigh );
         return root;
    }
}