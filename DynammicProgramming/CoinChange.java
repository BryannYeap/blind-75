class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        return cc(coins, amount, memo);
    }

    private int cc(int[] coins, int amount, int[] memo) {
        //cc(amount) = min(cc(amount - coins[i]) for each i) + 1;

        if (amount < 0) return -1;

        if (amount == 0) {
            memo[0] = 0;
            return 0;
        }

        if (memo[amount] != 0) return memo[amount];

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int numCoins = cc(coins, amount - coin, memo);
            if (numCoins >= 0) {
                res = Math.min(res, numCoins + 1);
            }
        }

        memo[amount] = res == Integer.MAX_VALUE ? -1 : res;
        return memo[amount];
    }
}

//================================================================================================================================

class IterativeSolution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int c : coins) {
                if (i - c >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - c]);
                }
            }
        }

        return (dp[amount] != amount + 1) ? dp[amount] : -1;
    }
}