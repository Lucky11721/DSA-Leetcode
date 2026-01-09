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
    HashMap<TreeNode , Integer> map = new HashMap<>();
    int maxDepth;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root == null) return null;

depth(root, 0);
        return LCA(root);
    }

    public TreeNode LCA(TreeNode root){
        if(root == null || map.get(root)  == maxDepth){
            return root;
        }

        TreeNode leftNode = LCA(root.left);
        TreeNode rightNode = LCA(root.right);

        if(leftNode != null && rightNode != null) return root;

        return leftNode != null ? leftNode : rightNode;
    }

    public void depth(TreeNode  root, int depth){
        if(root == null) return;

        map.put(root , depth);
        maxDepth = Math.max(maxDepth , depth);
        depth(root.left , depth+1);
        depth(root.right ,  depth +1);
    }
}