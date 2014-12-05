public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        return helper(0, preorder.length - 1, 0, inorder.length - 1, preorder, inorder);
    }
    
    public TreeNode helper(int pStart, int pEnd, int iStart, int iEnd, int[] preorder, int[] inorder) {
        if (pStart > pEnd || iStart > iEnd) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[pStart]);
        for (int i = iStart; i <= iEnd; i++) {
            if (preorder[pStart] == inorder[i]) {
                node.left = helper(pStart + 1, pStart + i- iStart, iStart, i - 1, preorder, inorder);
                node.right = helper(pStart + i- iStart + 1, pEnd, i + 1, iEnd, preorder, inorder);
                break;
            }
        }
        return node;
    }
}