public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        PriorityQueue<ListNode> q = new PriorityQueue<>(lists.size(), new Comparator<ListNode>() {
            public int compare(ListNode n1, ListNode n2) {
                return n1.val - n2.val;
            }
        });
        for (ListNode node : lists) {
            if (node != null) {
                q.add(node);
            }
        }
        ListNode newHead = new ListNode(0);
        ListNode temp = newHead;
        while (!q.isEmpty()) {
            ListNode node = q.poll();
            temp.next = node;
            if (node.next != null) {
                q.offer(node.next);
            }
            temp = temp.next;
        }
        return newHead.next;
    }
}