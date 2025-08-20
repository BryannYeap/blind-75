class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if not s:
            return 0
        
        l = 0
        maxLength = 1
        charSet = set([s[l]])
        currLength = 1
        for r in range(1, len(s)):
            if s[r] in charSet:
                while s[l] != s[r]:
                    charSet.remove(s[l])
                    l += 1
                l += 1
            charSet.add(s[r])
            currLength = r - l + 1
            maxLength = max(maxLength, currLength)
        
        return maxLength
            
                
