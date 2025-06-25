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

    public List<List<Integer>> levelOrder(TreeNode root) {
        ans = new ArrayList<>();
        if (root == null) return ans;

        bfs(root);
        return ans;
    }

    public void bfs(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while (!que.isEmpty()) {
            int size = que.size(); // Number of nodes in current level
            List<Integer> arr = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode current = que.poll();
                arr.add(current.val);

                if (current.left != null) {
                    que.add(current.left);
                }
                if (current.right != null) {
                    que.add(current.right);
                }
            }

            ans.add(arr); // Add current level list to answer
        }
    }
}
