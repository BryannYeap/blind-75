class Solution {
    public boolean canJump(int[] nums) {
        // T(nums[0,n]) = T(nums[k,n]) + T(nums[k+1,n]);
        boolean[] memo = new boolean[nums.length];
        memo[nums.length - 1] = true;

        for (int i = nums.length - 2; i >= 0; i--) {
            int steps = nums[i];
            for (int j = 1; j <= steps; j++) {
                int newIndex = i + j;
                if (newIndex < nums.length && memo[newIndex]) {
                    memo[i] = true;
                    break;
                }
            }
        }

        return memo[0];
    }
}