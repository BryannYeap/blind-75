class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] pre = new int[nums.length];
        int[] post = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i - 1 >= 0) {
                pre[i] = pre[i - 1] * nums[i - 1];
            } else {
                pre[i] = 1;
            }

            int postI = nums.length - 1 - i;
            if (postI + 1 < nums.length) {
                post[postI] = post[postI + 1] * nums[postI + 1];
            } else {
                post[postI] = 1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = pre[i] * post[i];
        }

        return nums;
    }
}