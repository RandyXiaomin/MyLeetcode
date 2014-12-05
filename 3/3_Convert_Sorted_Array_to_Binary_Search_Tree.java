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
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = helper(start, mid - 1, num);
        node.right = helper(mid + 1, end, num);
        return node;
    }
}