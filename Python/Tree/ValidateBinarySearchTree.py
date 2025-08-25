# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True
        
        def minValid(root, ceil):
            if not root:
                return True
            
            return root.val < ceil and minValid(root.right, ceil)
        
        def maxValid(root, floor):
            if not root:
                return True
            
            return root.val > floor and maxValid(root.left, floor)
        
        return self.isValidBST(root.left) and self.isValidBST(root.right) and minValid(root.left, root.val) and maxValid(root.right, root.val)
                