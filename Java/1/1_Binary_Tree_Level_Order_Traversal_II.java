public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        addLevel(nodes, ret);
        return ret;
    }
    
    public void addLevel(List<TreeNode> nodes, List<List<Integer>> ret) {
        List<TreeNode> newNodes = new ArrayList<>();
        for (TreeNode node : nodes) {
            if (node.left != null) {
                newNodes.add(node.left);
            }
            if (node.right != null) {
                newNodes.add(node.right);
            }
        }
        if (!newNodes.isEmpty()) {
            addLevel(newNodes, ret);
        }
        List<Integer> sol = new ArrayList<>();
        for (TreeNode node : nodes) {
            sol.add(node.val);
        }
        ret.add(sol);
    }
}