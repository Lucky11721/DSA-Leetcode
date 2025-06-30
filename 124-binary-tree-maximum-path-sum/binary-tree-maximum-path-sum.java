class Solution {
    public int maxPathSum(TreeNode root) {
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        maxGain(root, maxSum);
        return maxSum[0];
    }

    private int maxGain(TreeNode node, int[] maxSum) {
        if (node == null) return 0;

        // Only take positive contributions from left/right subtrees
        int leftGain = Math.max(0, maxGain(node.left, maxSum));
        int rightGain = Math.max(0, maxGain(node.right, maxSum));

        // Path including both children and the current node
        int currentPath = node.val + leftGain + rightGain;

        // Update max path sum
        maxSum[0] = Math.max(maxSum[0], currentPath);

        // Return max gain including one child to the parent call
        return node.val + Math.max(leftGain, rightGain);
    }
}
