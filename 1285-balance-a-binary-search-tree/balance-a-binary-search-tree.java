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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        inOrder(root , list);


        return buildTree(list , 0 , list.size() -1);

    }

    public void inOrder(TreeNode root , List<Integer> list){
        if(root == null) return;
        inOrder(root.left , list);
        list.add(root.val);
        inOrder(root.right , list);
    }

    public TreeNode buildTree(List<Integer> list , int start , int end){
    if(start > end) return null;

    int mid = start + (end -start)/2;
    TreeNode root = new TreeNode(list.get(mid));

    root.left = buildTree(list , start , mid-1);
    root.right = buildTree(list , mid+1 , end);


    return root;

    }
}