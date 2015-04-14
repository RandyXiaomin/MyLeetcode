public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preNode = head;
        ListNode temp = head.next;
        while (temp != null) {
            if (temp.val == preNode.val) {
                preNode.next = temp.next;
            } else {
                preNode = temp;
            }
            temp = temp.next;
        }
        return head;
    }
}