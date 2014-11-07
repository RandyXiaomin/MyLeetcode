public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode small = new ListNode(0);
        ListNode tailSmall = small;
        ListNode preNode = newHead;
        while (preNode.next != null) {
            if (preNode.next.val < x) {
                tailSmall.next = preNode.next;
                preNode.next = preNode.next.next;
                tailSmall = tailSmall.next;
            } else {
                preNode = preNode.next;
            }
        }
        tailSmall.next = newHead.next;
        return small.next;
    }
}