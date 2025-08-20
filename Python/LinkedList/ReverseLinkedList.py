# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head is None:
            return head
        
        nextNode = None
        currNode = head
        while (currNode is not None):
            temp = currNode.next
            currNode.next = nextNode
            nextNode = currNode
            currNode = temp
        
        return nextNode

        