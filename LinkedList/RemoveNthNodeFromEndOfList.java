package LinkedList;

import LinkedList.utils.ListNode;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        return remove(head, length - n);
    }

    private ListNode remove(ListNode head, int n) {
        if (head == null) return null;

        return n == 0 
        ? remove(head.next, n - 1) 
        : new ListNode(head.val, remove(head.next, n - 1));
    }
}