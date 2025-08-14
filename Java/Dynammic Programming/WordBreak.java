class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // wb(0,n) = (wb(0,k) && wb(k,n)) || (wb(0,j) && wb(j,n))
        Set<String> set = new HashSet<>();
        
        for (String word : wordDict) {
            set.add(word);
        }
        
        int[] memo = new int[s.length()];
        
        return helper(s, set, 0, memo);
    }

    private boolean helper(String s, Set<String> set, int start, int[] memo) {
        if (start >= s.length()) return true;
        if (memo[start] != 0) return memo[start] == 1;
        
        StringBuffer sb = new StringBuffer();
        
        boolean res = false;
        for (int i = start; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (set.contains(sb.toString())) {
                res |= helper(s, set, i+1, memo);
            }
        }
        
        
        memo[start] = res || set.contains(sb.toString()) ? 1 : 2;
        return memo[start] == 1;
    }
}
