public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0) {
            return null;
        }
        return helper(0, num.length - 1, num);
    }
    
    public TreeNode helper(int start, int end, int[] num) {
        if (start > end) {
            return null;
        }
        int mid = (end + start) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = helper(start, mid - 1, num);
        root.right = helper(mid + 1, end, num);
        return root;
    }
}