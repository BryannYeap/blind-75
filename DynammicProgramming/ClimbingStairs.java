class Solution {
    int[] memo = new int[45 + 1];

    public int climbStairs(int n) {
        if (memo[n] != 0) return memo[n];

        if (n <= 1) {
            memo[n] = 1;
            return 1;
        }

        if (n == 2) {
            memo[n] = 2;
            return 2;
        }

        // num(n) = num(n - 1) + num(n - 2)
        int res = climbStairs(n - 1) + climbStairs(n - 2);
        memo[n] = res;
        return res;
    }
}