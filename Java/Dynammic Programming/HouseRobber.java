class Solution {
    public int rob(int[] nums) {
        // T(i, n) = Max(nums[i] + T(i+2, n), T(i+1, n))

        int len = nums.length;
        int[] memo = new int[len];
        memo[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            memo[i] = (i + 2 < len) 
                ? Math.max(nums[i] + memo[i+2], memo[i+1])
                : Math.max(nums[i], memo[i+1]);
        }

        return memo[0];
    }
}