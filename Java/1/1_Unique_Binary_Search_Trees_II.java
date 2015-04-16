public class Solution {
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }
    
    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> ret = new ArrayList<>();
        if (start > end) {
            ret.add(null);
            return ret;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> listLeft = generateTrees(start, i - 1);
            List<TreeNode> listRight = generateTrees(i + 1, end);
            for (TreeNode left : listLeft) {
                for (TreeNode right : listRight) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    ret.add(root);
                }
            }
        }
        return ret;
    }
}