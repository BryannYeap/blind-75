class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);

        if (nums.length < 3) return new ArrayList<>(res);
        
        for (int i = 0; i < nums.length - 2; i++) {
            int curr = nums[i];

            if (curr > 0) break;

            int slow = i + 1;
            int fast = nums.length - 1;
            while (slow < fast) {
                int addition = curr + nums[slow] + nums[fast];
                if (addition < 0) {
                    slow++;
                } else if (addition > 0) {
                    fast--;
                } else {
                    res.add(Arrays.asList(nums[i],nums[slow],nums[fast]));
                    slow++;
                    fast--;
                }
            }
        }

        return new ArrayList<>(res);
    }
}