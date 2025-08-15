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
  
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        
        return helper(preorder, inorder , 0 , n-1, 0 , n-1);

    }
    public TreeNode helper(int[] pre , int[] in , int prelow , int prehigh , int inlow , int inhigh){
        if(prelow > prehigh || inlow > inhigh) return null;

         TreeNode root = new TreeNode(pre[prelow]);
        int root_index = 0;
        for(int  i =0 ; i < in.length ; i++){
            if(root.val == in[i]){
                root_index = i;
                break;
            }
        }
        int lst_size = root_index - inlow;

        root.left = helper(pre , in , prelow+1 , prelow + lst_size , inlow , root_index-1);
        root.right = helper(pre , in , prelow + lst_size+1 , prehigh , root_index+1 , inhigh);

        return root;
    }
}