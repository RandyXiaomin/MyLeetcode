public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode temp = newHead;
        while (temp.next != null) {
            ListNode tempHead = temp;
            Stack<ListNode> stack = new Stack<>();
            for (int i = 0; i < k; i++) {
                if (temp.next != null) {
                    stack.push(temp.next);
                } else {
                    return newHead.next;
                }
                temp = temp.next;
            }
            ListNode tail = temp.next;
            while (!stack.isEmpty()) {
                tempHead.next = stack.pop();
                tempHead = tempHead.next;
            }
            /*
             *  tempHead.next = temp.next would fail because temp.next changed during poping stack.
             */
            tempHead.next = tail;
            temp = tempHead;
        }
        return newHead.next;
    }
}