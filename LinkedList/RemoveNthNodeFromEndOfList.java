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

//===========================================================================================================

class OnePassSolution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;
        for (int i = 0; i < n; i++) fast = fast.next;
        if (fast == null) return head.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}