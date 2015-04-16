public class Solution {
    int ret = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        getMaxSum(root);
        return ret;
    }
    
    public int getMaxSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, getMaxSum(root.left));
        int right = Math.max(0, getMaxSum(root.right));
        int sum = root.val + Math.max(left, right);
        ret = Math.max(root.val + left + right, (Math.max(sum, ret)));
        return sum;
    }
}