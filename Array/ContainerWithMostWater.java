class Solution {
    public int maxArea(int[] height) {
        int index1 = 0;
        int index2 = height.length - 1;
        int maxRes = getVol(index1, index2, height);
        while (index1 < index2) {
            if (height[index1] < height[index2]) {
                int curr = index1;
                while (index1 < index2) {
                    index1++;
                    if (index1 < index2 && height[curr] < height[index1]) {
                        maxRes = Math.max(maxRes, getVol(index1, index2, height));
                        break;
                    }
                }
            } else {
                int curr = index2;
                while (index1 < index2) {
                    index2--;
                    if (index1 < index2 && height[curr] < height[index2]) {
                        maxRes = Math.max(maxRes, getVol(index1, index2, height));
                        break;
                    }
                }
            }
        }
        return maxRes;
    }

    private int getVol(int index1, int index2, int[] height) {
        return (index2 - index1) * Math.min(height[index1], height[index2]);
    }
}