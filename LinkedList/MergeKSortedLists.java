package LinkedList;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        int min = Integer.MAX_VALUE;
        int minListIndex = -1;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) continue;
            if (lists[i].val < min) {
                min = lists[i].val;
                minListIndex = i;
            }
        }

        if (minListIndex == -1) return null;

        ListNode node = lists[minListIndex].next;
        
        if (node != null) {
            lists[minListIndex] = node;
            return new ListNode(min, mergeKLists(lists));
        } else {
            ListNode[] newList = new ListNode[lists.length - 1];
            int j = 0;
            for (int i = 0; i < lists.length; i++) {
                if (i == minListIndex) {
                    continue;
                }
                newList[j++] = lists[i];
            }
            return new ListNode(min, mergeKLists(newList));
        }
    }
}

//===========================================================================================================

class ShorterSolution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        int min = Integer.MAX_VALUE;
        int minListIndex = -1;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) continue;
            if (lists[i].val < min) {
                min = lists[i].val;
                minListIndex = i;
            }
        }

        if (minListIndex == -1) return null;

        lists[minListIndex] = lists[minListIndex].next;
        return new ListNode(min, mergeKLists(lists));
    }
}