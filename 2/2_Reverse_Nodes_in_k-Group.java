public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        int num = 0;
        for (ListNode temp = newHead; temp.next != null; temp = temp.next) {
            num++;
        }
        for (ListNode temp = newHead; num >= k; num -= k) {
            temp = reverse(temp, k);
        }
        return newHead.next;
    }
    
    public ListNode reverse(ListNode head, int k) {
        ListNode tempHead = head.next;
        ListNode tempTail = tempHead;
        ListNode tail = tempHead.next;
        for (int i = 1; i < k; i++) {
            ListNode n = tail;
            tail = tail.next;
            n.next = tempHead;
            tempHead = n;
        }
        head.next = tempHead;
        tempTail.next = tail;
        return tempTail;
    }
}