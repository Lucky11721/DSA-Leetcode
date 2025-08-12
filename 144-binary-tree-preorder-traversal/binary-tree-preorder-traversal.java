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
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        List<Integer> arr = new ArrayList<>();

        if(curr != null){
            st.push(curr);
        }
        while(curr != null && st.isEmpty() == false){
            TreeNode top = st.pop();
            arr.add(top.val);

            if(top.right != null){
                st.add(top.right);
            }
            if(top.left != null){
                st.add(top.left);
            }
        }

        return arr;
    }
}