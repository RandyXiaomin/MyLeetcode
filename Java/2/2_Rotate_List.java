public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || head.next == null || n <= 0) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
            if (fast.next != null) {
                fast = fast.next;
            } else {
                /*
                 *  {1, 2} 3 ---> {2, 1}
                 */
                fast = head;
                n = n % (i + 1);
                i = -1;
            }
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }
}

public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || head.next == null || n <= 0) {
            return head;
        }
        int num = 1;
        ListNode temp = head;
        for (;temp.next != null; num++) {
            temp = temp.next;
        }
        temp.next = head;
        n = num - n % num;
        for (int i = 0; i < n; i++) {
            temp = temp.next;
        }
        ListNode newHead = temp.next;
        temp.next = null;
        return newHead;
    }
}