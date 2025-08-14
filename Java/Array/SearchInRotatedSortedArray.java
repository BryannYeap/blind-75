class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int middle = start + (end - start) / 2;
            if (nums[middle] > nums[end]) {
                start = middle + 1;
            } else {
                end = middle;
            }
        }

        if (target > nums[nums.length - 1]) {
            end = start - 1;
            start = 0;
        } else {
            end = nums.length - 1;
        }

        while (start < end) {
            int middle = start + (end - start) / 2;
            if (target > nums[middle]) {
                start = middle + 1;
            } else {
                end = middle;
            }
        }

        return nums[start] == target ? start : -1;
    }
}