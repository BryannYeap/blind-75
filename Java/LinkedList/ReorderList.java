package LinkedList;

class Solution {
    public void reorderList(ListNode head) {
        if (head == null) return;
        if (head.next == null) return;

        ArrayList<ListNode> ls = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            ls.add(curr);
            curr = curr.next;
        }

        int a = 0;
        int b = ls.size() - 1;
        int counter = 0;
        while (counter++ < ls.size() - 1) {
            ls.get(a).next = ls.get(b);
            ls.get(b).next = null;
            
            int temp = a;
            if (a < b) {
                a = b;
                b = temp + 1;
            } else {
                a = b;
                b = temp - 1;
            }
        }
    }
}