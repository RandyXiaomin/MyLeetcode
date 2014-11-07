public class Solution {
    public void connect(TreeLinkNode root) {
        while (root != null) {
            root = helper(root);
        }
    }
    
    public TreeLinkNode helper(TreeLinkNode root) {
        /*
         *  link nodes line by line
         */
        TreeLinkNode res = new TreeLinkNode(0);
        TreeLinkNode temp = res;
        while (root != null && root.left != null) {
            temp.next = root.left;
            temp.next.next = root.right;
            temp = temp.next.next;
            root = root.next;
        }
        return res.next;
    }
}