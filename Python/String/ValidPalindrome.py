class Solution:
    def isPalindrome(self, s: str) -> bool:
        lowerStr = s.lower()
        l = 0
        r = len(s) - 1
        while l < r:
            if not lowerStr[l].isalnum():
                l+=1
                continue
            if not lowerStr[r].isalnum():
                r-=1
                continue
            if lowerStr[l] != lowerStr[r]:
                return False
            else:
                l+=1
                r-=1
        return True
    