class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--){
                memo[i][j] = (i == m - 1 || j == n - 1) 
                    ? 1
                    : memo[i + 1][j] + memo[i][j + 1];
            }
        }
        return memo[0][0];
    }

}