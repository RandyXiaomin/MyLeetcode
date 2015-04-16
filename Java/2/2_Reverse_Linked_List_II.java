public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) {
            return head;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode currentNode = newHead;
        for (int i = 1; i < m; i++) {
            currentNode = currentNode.next;
        }
        ListNode pre = currentNode;
        currentNode = currentNode.next;
        head = currentNode;
        for (int i = 0; i < n - m; i++) {
            ListNode tempNode = currentNode.next.next;
            currentNode.next.next = head;
            head = currentNode.next;
            currentNode.next = tempNode;
            
        }
        pre.next = head;
        return newHead.next;
    }
}