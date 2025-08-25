class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        prefixProduct = len(nums) * [1]
        postFixProduct = len(nums) * [1]
        prefixProduct[0] = nums[0]
        postFixProduct[-1] = nums[-1]
        for i in range(1, len(nums)):
            prefixProduct[i] = nums[i] * prefixProduct[i - 1]
        for i in range(len(nums) - 2, -1, -1):
            postFixProduct[i] = nums[i] * postFixProduct[i + 1]
        
        res = []
        for i in range(len(nums)):
            left = prefixProduct[i - 1] if i > 0 else 1
            right = postFixProduct[i + 1] if i < len(nums) - 1 else 1 
            res.append(left * right)
        
        return res

        