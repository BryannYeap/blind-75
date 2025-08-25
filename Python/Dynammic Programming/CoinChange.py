# Recursive 
class Solution:

    def coinChange(self, coins: List[int], amount: int) -> int:
        # dp(n) = min(dp(n - k) + 1) for k in coins
        memo = [0] * (amount + 1)
        for coin in coins:
            if coin <= amount:
                memo[coin] = 1

        def dp(amount):
            nonlocal memo
            if amount < 0:
                return -1

            if amount == 0:
                return 0

            if memo[amount] != 0:
                return memo[amount]
            
            minCoins = float('inf')
            for coin in coins:
                coinNeeded = dp(amount - coin)
                if coinNeeded != -1:
                    minCoins = min(coinNeeded + 1, minCoins)
            memo[amount] = -1 if minCoins == float('inf') else minCoins
            return memo[amount]

        return dp(amount)

# Iterative 
class Solution:

    def coinChange(self, coins: List[int], amount: int) -> int:
        # dp(n) = min(dp(n - k) + 1) for k in coins
        memo = [0] * (amount + 1)
        for i in range(1, amount + 1):
            res = float("inf")
            for coin in coins:
                if (i - coin >= 0) and memo[i - coin] != -1 :
                    res = min(memo[i - coin] + 1, res)
            memo[i] = -1 if res == float("inf") else res
        return memo[amount]