class Solution {

    final int MOD = (int)Math.pow(10,9) + 7;
    long ans = 0;

    public int maxProduct(TreeNode root) {

        long treeSum = findSum(root);
        dfs(root, treeSum);
        return (int)(ans % MOD);
    }

    public long dfs(TreeNode root, long treeSum) {
         if (root == null) return 0;

        long leftTreeSum = dfs(root.left, treeSum);
        long rightTreeSum = dfs(root.right, treeSum);

        long subTreeSum = root.val + leftTreeSum + rightTreeSum;

        long product = subTreeSum * (treeSum - subTreeSum);
        ans = Math.max(ans, product);

        return subTreeSum;
    }

    public long findSum(TreeNode root) {
        if (root == null) return 0;

        return root.val
                + findSum(root.left)
                + findSum(root.right);
    }
}
