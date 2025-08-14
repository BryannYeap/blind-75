class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        indexMap = {}
        for i in range(len(nums)):
            remainder = target - nums[i]
            j = indexMap.get(remainder)
            if (j != None):
                return [i,j]
            indexMap[nums[i]] = i
        return []
