public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode n1 = newHead;
        while (n1.next != null) {
            ListNode n2 = n1.next;
            while (n2.next != null &&  n2.val == n2.next.val) {
                n2 = n2.next;
            }
            if (n1.next == n2) {
                n1 = n2;
            } else {
                n1.next = n2.next;
            }
        }
        return newHead.next;
    }
}

// public class Solution {
//     public ListNode deleteDuplicates(ListNode head) {
//         if (head == null || head.next == null) {
//             return head;
//         }
//         ListNode newHead = new ListNode(0);
//         newHead.next = head;
//         ListNode preNode = newHead;
//         ListNode currentNode = head.next;
//         boolean isDup = false;
//         while (currentNode != null) {
//             if (currentNode.val == preNode.next.val) {
//                 isDup = true;
//             } else {
//                 if (isDup) {
//                     preNode.next = currentNode;
//                     isDup = false;
//                 } else {
//                     preNode = preNode.next;  
//                 }
//             }
//             currentNode = currentNode.next;
//         }
//         if (isDup) {
//             preNode.next = null;
//         }
//         return newHead.next;
//     }
// }