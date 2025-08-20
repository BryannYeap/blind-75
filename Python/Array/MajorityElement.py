
class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        numFreq = {}
        for num in nums:
            numFreq[num] = numFreq.get(num, 0) + 1
            if (numFreq[num] > len(nums) / 2):
                return num
        return -1