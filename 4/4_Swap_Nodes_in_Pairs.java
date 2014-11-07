public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode temp = newHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode n1 = temp.next;
            ListNode n2 = n1.next;
            temp.next = n1.next;
            n1.next = n2.next;
            n2.next = n1;
            temp = n1;
        }
        return newHead.next;
    }
}