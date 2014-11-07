public class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] res = new int[1];
        helper(root, 0, res);
        return res[0];
    }
    
    public void helper(TreeNode root, int cur, int[] res) {
        cur = cur * 10 + root.val;
        if (root.left == null && root.right == null) {
            res[0] += cur;
            return;
        }
        if (root.left != null) {
            helper(root.left, cur, res);
        }
        if (root.right != null) {
            helper(root.right, cur, res);
        }
    }
}