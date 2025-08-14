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
    List<Integer> list = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        bfs(root);
        return list;
    }

    public void bfs(TreeNode root){
         Queue<TreeNode> que = new LinkedList<>();

        que.add(root);

        while(que.isEmpty() == false){
             TreeNode rightNode = null;
             int n = que.size();

             for(int i =0 ; i <  n ; i++){
                TreeNode temp = que.remove();
                if(temp != null){
                     rightNode = temp;
                     que.add(temp.left);
                     que.add(temp.right);
                }
             }
             if(rightNode != null){
                list.add(rightNode.val);
             }
        }

    }
}