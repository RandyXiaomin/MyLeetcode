public class Solution {
    public boolean isBalanced(TreeNode root) {
        return root != null ? isBalanced(root.left) && isBalanced(root.right) && Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1 : true;
    }
    
    public int getHeight(TreeNode root) {
        return root != null ? Math.max(getHeight(root.left), getHeight(root.right)) + 1 : 0;
    }
}