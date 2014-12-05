public class Solution {
    public void connect(TreeLinkNode root) {
        for (;root != null && root.left != null; root = root.left) {
            for (TreeLinkNode temp = root; temp != null; temp = temp.next) {
                temp.left.next = temp.right;
                temp.right.next = temp.next != null ? temp.next.left : null;
            }
        }
    }
}