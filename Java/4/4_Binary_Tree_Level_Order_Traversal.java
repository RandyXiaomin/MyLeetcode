public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        List<List<Integer>> res = new LinkedList();
        if (root == null) {
            return res;
        }
        q.offer(root);
        while (!q.isEmpty()) {
            int num = q.size();
            List<Integer> list = new LinkedList();
            for (int i = 0; i < num; i++) {
                TreeNode node = q.poll();
                list.add(node.val);
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}