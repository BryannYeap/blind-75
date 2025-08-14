class Solution {
    public int rob(int[] nums) {
        // T(i, n) = Max(nums[i] + T(i+2, n), T(i+1, n))

        int len = nums.length;
        int[] memoRobFirst = new int[len]; // index 0 to n-2
        int[] memoRobLast = new int[len]; // index 1 to n-1

        memoRobLast[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            memoRobFirst[i] = (i + 2 < len)
                    ? Math.max(nums[i] + memoRobFirst[i+2], memoRobFirst[i+1])
                    : Math.max(nums[i], memoRobFirst[i+1]);

            if (i != 0) {
                memoRobLast[i] = (i + 2 < len)
                    ? Math.max(nums[i] + memoRobLast[i+2], memoRobLast[i+1])
                    : Math.max(nums[i], memoRobLast[i+1]);
            } else {
                memoRobLast[i] = (i + 1 < len) 
                    ? memoRobLast[i+1]
                    : nums[i];
            }
        }

        return Math.max(memoRobFirst[0], memoRobLast[0]);
    }
}