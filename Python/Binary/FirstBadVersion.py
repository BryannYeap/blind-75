class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l = 0
        r = len(nums) - 1
        while l < r:
            index = l + (r-l)//2
            if (nums[index] < target):
                l = index + 1
            else:
                r = index
        return l if nums[l] == target else -1
