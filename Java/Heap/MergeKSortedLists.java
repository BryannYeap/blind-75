/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((x,y) -> x.val - y.val);
        ListNode dummy = new ListNode();
        ListNode res = dummy;

        for (ListNode list : lists) {
            if (list != null) minHeap.add(list);
        }

        while (!minHeap.isEmpty()) {
            ListNode list = minHeap.poll();
            dummy.next = new ListNode(list.val);
            dummy = dummy.next;
            if (list.next != null) minHeap.add(list.next);
        }

        return res.next;
    }
}