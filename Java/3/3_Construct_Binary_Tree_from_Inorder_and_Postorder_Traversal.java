public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0 || inorder.length != postorder.length) {
            return null;
        }
        return helper(0, inorder.length - 1, 0, postorder.length - 1, inorder, postorder);
    }
    
    public TreeNode helper(int iStart, int iEnd, int pStart, int pEnd, int[] inorder, int[] postorder) {
        if (iStart > iEnd || pStart > pEnd) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[pEnd]);
        for (int i = iStart; i <= iEnd; i++) {
            if (inorder[i] == postorder[pEnd]) {
                node.left = helper(iStart, i - 1, pStart, pStart + i - iStart - 1, inorder, postorder);
                node.right = helper(i + 1, iEnd, pStart + i - iStart, pEnd - 1, inorder, postorder);
            }
        }
        return node;
    }
}