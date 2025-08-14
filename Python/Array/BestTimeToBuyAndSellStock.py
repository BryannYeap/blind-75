class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        buy = float('inf')
        res = 0
        currMax = 0
        for price in prices:
            if price < buy:
                buy = price
            else:
                currMax = max(currMax, price - buy)
                res = max(currMax, res)

        return res
