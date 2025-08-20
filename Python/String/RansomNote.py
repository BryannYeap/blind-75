class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        charFreq = {}
        for c in magazine:
            charFreq[c] = charFreq.get(c,0) + 1
        
        for c in ransomNote:
            newFreq = charFreq.get(c,0) - 1
            if (newFreq < 0):
                return False
            else:
                charFreq[c] = newFreq

        return True