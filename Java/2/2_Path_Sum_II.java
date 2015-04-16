public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        pathSum(new ArrayList<Integer>(), root, sum, ret);
        return ret;
    }
    
    public void pathSum(List<Integer> current, TreeNode root, int sum, List<List<Integer>> ret) {
        if (root == null) {
            return;
        }
        sum -= root.val;
        current.add(root.val);
        if (sum == 0 && root.left == null && root.right == null) {
            ret.add(current);
            return;
        }
        pathSum(new ArrayList<Integer>(current), root.left, sum, ret);
        pathSum(new ArrayList<Integer>(current), root.right, sum, ret);
    }
}