public class Solution {
    public void connect(TreeLinkNode root) {
        while (root != null) {
            TreeLinkNode newHead = null;
            TreeLinkNode pre = null;
            while (root != null) {
                if (root.left != null) {
                    if (newHead == null) {
                        newHead = root.left;
                        pre = newHead;
                    } else {
                        pre.next = root.left;
                        pre = pre.next;
                    }
                }
                if (root.right != null) {
                    if (newHead == null) {
                        newHead = root.right;
                        pre = newHead;
                    } else {
                        pre.next = root.right;
                        pre = pre.next;
                    }
                }
                root = root.next;
            }
            root = newHead;
        }
    }
}