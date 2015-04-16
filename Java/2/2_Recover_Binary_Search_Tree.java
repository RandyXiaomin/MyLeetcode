public class Solution {
    TreeNode node1 = null;
    TreeNode node2 = null;
    TreeNode prev = null;
    
    public void recoverTree(TreeNode root) {
        inorderTraversal(root);
        int temp = node2.val;
        node2.val = node1.val;
        node1.val = temp;
    }
    
    public void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        if (prev != null && root.val < prev.val) {
            node1 = node1 == null ? prev : node1;
            node2 = root;
        }
        prev = root;
        inorderTraversal(root.right);
    }
}