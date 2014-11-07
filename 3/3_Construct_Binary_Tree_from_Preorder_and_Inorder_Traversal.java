public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    
    public TreeNode helper(int[] preorder, int[] inorder, int s1, int e1, int s2, int e2) {
        if(s1 > e1 || s2 > e2) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[s1]);
        int leftLen = 0;
        int rightLen = 0;
        for (int i = s2; i <= e2; i++) {
            if (inorder[i] == preorder[s1]) {
                leftLen = i - s2;
                rightLen = e1 - s1 - leftLen;
                break;
            }
        }
        root.left = helper(preorder, inorder, s1 + 1, s1 + leftLen, s2, s2 + leftLen - 1);
        root.right = helper(preorder, inorder, e1 - rightLen + 1, e1, e2 - rightLen + 1, e2);
        return root;
    }
}