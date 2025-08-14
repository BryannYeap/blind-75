import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (map.get(target - curr) != null) {
                return new int[]{i, map.get(target - curr)};
            }

            map.put(curr, i);
        }

        return new int[2];
    }
}