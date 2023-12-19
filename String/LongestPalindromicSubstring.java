class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        int maxI = 0;
        int maxJ = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] oddRes = extendPalindrome(s, i, i, 1);     // odd
            int[] evenRes = extendPalindrome(s, i, i + 1, 0); // even

            int maxCount = Math.max(oddRes[2], evenRes[2]);
            max = Math.max(max, maxCount);
            if (max == maxCount) {
                if (maxCount == oddRes[2]) {
                    maxI = oddRes[0];
                    maxJ = oddRes[1];
                } else {
                    maxI = evenRes[0];
                    maxJ = evenRes[1];
                }
            }
        }
        return s.substring(maxI, maxJ + 1);    
    }

    private int[] extendPalindrome(String s, int left, int right, int count) {
        int i = left;
        int j = right;
        int[] res = new int[]{i,j,count};

        if (count == 1) {
            i--;
            j++;
        }

        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            count += 2;
            res[0] = i;
            res[1] = j;
            res[2] = count;
            i--;
            j++;
        }

        return res;
    }
}