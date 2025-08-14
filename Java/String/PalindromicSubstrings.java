class Solution {
    public int countSubstrings(String s) {
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                int slow = i;
                int fast = j;
                
                boolean palindrome = true;
                while (slow <= fast) {
                    if (s.charAt(fast) != s.charAt(slow)) {
                        palindrome = false;
                        break;
                    }
                    fast--;
                    slow++;
                }

                if (palindrome) res++;
            }
        }

        return res;
    }
}

//===========================================================================================================

public class LinearSolution {
    int count = 0;
    
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        
        for (int i = 0; i < s.length(); i++) { // i is the mid point
            extendPalindrome(s, i, i); // odd length;
            extendPalindrome(s, i, i + 1); // even length
        }
        
        return count;
    }
    
    private void extendPalindrome(String s, int left, int right) {
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++; left--; right++;
        }
    }
}