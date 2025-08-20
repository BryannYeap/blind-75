class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        indexMap = {}
        nums.sort() # nlogn

        for i in range(0, len(nums)):
            num = nums[i]
            indexMap[num] = i

        res = []
        done = set()
        for i in range(len(nums)):
            num1 = nums[i]
            for j in range(i+1, len(nums)): # n^2
                num2 = nums[j]
                if ((num1, num2) in done):
                    continue
                num3 = 0 - num1 - num2
                k = indexMap.get(num3, None)
                if k and k > j:
                    done.add((num1, num2))
                    res.append([num1, num2, num3])
                    continue
        
        return list(res)
                    