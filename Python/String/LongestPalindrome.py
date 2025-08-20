class Solution:
    def longestPalindrome(self, s: str) -> int:
        charFreq = {}
        for c in s:
            charFreq[c] = charFreq.get(c, 0) + 1
        
        length = 0
        hasOdd = False
        for value in charFreq.values():
            print(value)
            if value % 2 == 0:
                length += value
            else:
                hasOdd = True
                length += value - 1
        return length + 1 if hasOdd else length

        