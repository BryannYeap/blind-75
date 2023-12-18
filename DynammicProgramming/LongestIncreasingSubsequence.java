class Solution {
    public int lengthOfLIS(int[] nums) {
        // T(0,n) = T(0,i) + (nums[i] < nums[i + 1] ? 1 : 0)
        int[] memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        helper(nums, memo, nums.length - 1);

        int max = -1;
        for (int n : memo) {
            max = Math.max(max, n);
        }
        return max;
    }

    private int helper(int[] nums, int[] memo, int n) {
        if (memo[n] != -1) return memo[n];

        int max = -1;
        for (int i = 0; i < n; i++) {
            int longestTillI = helper(nums, memo, i);
            if (nums[i] < nums[n]) {
                max = Math.max(longestTillI + 1, max);
            }
        }

        memo[n] = max == -1 ? 1 : max;
        return memo[n];
    }
}

//================================================================================================================================

class IterativeSolution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n;
        }

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 1;
        for (int length : dp) {
            max = Math.max(max, length);
        }

        return max;
    }
}