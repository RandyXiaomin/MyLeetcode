public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0 || inorder.length != postorder.length) {
            return null;
        }
        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
    
    public TreeNode helper(int[] inorder, int[] postorder, int s1, int e1, int s2, int e2) {
        if (s1 > e1 || s2 > e2) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[e2]);
        int leftLen = 0;
        int rightLen = 0;
        for (int i = s1; i <= e1; i++) {
            if (inorder[i] == postorder[e2]) {
                leftLen = i - s1;
                rightLen = e1 - s1 - leftLen;
                break;
            }
        }
        root.left = helper(inorder, postorder, s1, s1 + leftLen - 1, s2, s2 + leftLen - 1);
        root.right = helper(inorder, postorder, e1 - rightLen + 1, e1, e2 - rightLen, e2 - 1);
        return root;
    }
}