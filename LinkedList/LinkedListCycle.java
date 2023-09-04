package LinkedList;

import java.util.HashSet;

import LinkedList.utils.ListNode;

class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;

        HashSet<ListNode> set = new HashSet<>();

        while (head != null) {
            if (set.contains(head))
                return true;

            set.add(head);
            head = head.next;
        }

        return false;
    }
}


//================================================================================================================================


class OptimalSolution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }

        return false;
    }
}
