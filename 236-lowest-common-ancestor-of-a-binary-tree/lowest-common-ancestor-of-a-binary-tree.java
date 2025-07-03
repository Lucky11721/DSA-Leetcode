/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean exist(TreeNode root ,  TreeNode node){
        if(node==root){
            return true;
        }
        if(root == null){
            return false;
        }

        return exist(root.left,node) ||  exist(root.right,node);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==p || root==q){
            return root;
        }
        boolean PliesInLST = exist(root.left , p);
        boolean QliesInLST = exist(root.left , q);
        if(PliesInLST == true && QliesInLST == true){
            return  lowestCommonAncestor(root.left , p ,q);
        }
        if(PliesInLST == false && QliesInLST == false){
            return  lowestCommonAncestor(root.right , p ,q);
        }
        else{
            return root;
        }


}
}