public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        return helper(root, sum, 0);
    }
    
    public boolean helper(TreeNode node, int sum, int curSum) {
        if (node == null) {
            return false;
        }
        curSum += node.val;
        if (node.left == null && node.right == null) {
            return curSum == sum;
        }
        boolean res = false;
        if (node.left != null) {
            res = res || helper(node.left, sum, curSum);
        }
        if (node.right != null) {
            res = res || helper(node.right, sum, curSum);
        }
        return res;
    }
}