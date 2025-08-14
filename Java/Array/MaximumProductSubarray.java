class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int curr = 1;
        
        for (int num : nums) {
            curr *= num;
            max = Math.max(curr, max);
            if (curr == 0) {
                curr = 1;
            }
        }
        
        
        curr = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            curr *= nums[i];
            max = Math.max(curr, max);
            if (curr == 0) {
                curr = 1;
            }
        }
        
        return max;
    }
}