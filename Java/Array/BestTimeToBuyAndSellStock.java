class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int buy = prices[0];
        for (int price : prices) {
            int profit = price - buy;
            max = Math.max(max, profit);
            if (profit < 0) {
                buy = price;
            }
        }

        return max >= 0 ? max : 0;
    }
}