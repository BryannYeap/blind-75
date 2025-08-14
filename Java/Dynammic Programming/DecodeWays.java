class Solution {

    public int numDecodings(String s) {
        int[] memo = new int[s.length()];
        char[] sArr = s.toCharArray();
        memo[memo.length - 1] = sArr[memo.length - 1] >= '1'
            ? 1
            : 0;

        for (int i = memo.length - 2; i >= 0; i--){
            if (sArr[i] >= '1') {
                memo[i] += memo[i+1];
            }

            if (i+1 < memo.length) {
                if ((sArr[i] == '1' && sArr[i+1] <= '9') || 
                    (sArr[i] == '2' && sArr[i+1] <= '6')) {
                    if (i + 2 < memo.length) {
                        memo[i] += memo[i+2];
                    } else {
                        memo[i] += 1;
                    }
                }
            }
        }

        return memo[0];
    }
}