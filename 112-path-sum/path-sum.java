class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        // If it's a leaf node, check if the path sum equals targetSum
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        // Recursively check left and right subtree
        return hasPathSum(root.left, targetSum - root.val) || 
               hasPathSum(root.right, targetSum - root.val);
    }
}
