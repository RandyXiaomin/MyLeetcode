public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Stack<TreeNode> s = new Stack<>();
        s.add(root);
        boolean nextOrderRightToLeft = true;
        while (!s.isEmpty()) {
            Stack<TreeNode> temp = new Stack<>();
            List<Integer> sol = new ArrayList<>();
            while (!s.isEmpty()) {
                TreeNode node = s.pop();
                if (node != null) {
                    sol.add(node.val);
                    if (nextOrderRightToLeft) {
                        temp.add(node.left);
                        temp.add(node.right);
                    } else {
                        temp.add(node.right);
                        temp.add(node.left);
                    }
                }
            }
            if (!sol.isEmpty()) {
                ret.add(sol);
            }
            nextOrderRightToLeft = !nextOrderRightToLeft;
            s = temp;
        }
        return ret;
    }
}