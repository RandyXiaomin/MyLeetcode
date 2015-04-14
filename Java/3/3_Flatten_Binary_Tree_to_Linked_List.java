public class Solution {
    public void flatten(TreeNode root) {
        root = helper(root);
    }
    
    public TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tempRight = helper(root.right);
        root.right = helper(root.left);
        root.left = null;
        TreeNode temp = root;
        while (temp.right != null) {
            temp = temp.right;
        }
        temp.right = tempRight;
        return root;
    }
}