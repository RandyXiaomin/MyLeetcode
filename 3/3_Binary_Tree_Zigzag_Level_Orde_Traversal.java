/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        boolean order = false;
        while (!list.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            List<TreeNode> newList = new ArrayList<>();
            for (TreeNode node : list) {
                temp.add(node.val);
            }
            res.add(temp);
            /*
             *  or use stack, 
             */
            for (int i = list.size() - 1; i >= 0 ; i--) {
                TreeNode node = list.get(i);
                if (order) {
                    if (node.left != null) {
                        newList.add(node.left);
                    }
                    if (node.right != null) {
                        newList.add(node.right);
                    }
                } else {
                    if (node.right != null) {
                        newList.add(node.right);
                    }
                    if (node.left != null) {
                        newList.add(node.left);
                    }
                }
            }
            order = !order;
            list = new ArrayList<>(newList);
        }
        return res;
    }
}