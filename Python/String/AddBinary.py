class Solution:
    def addBinary(self, a: str, b: str) -> str:
        aRev = a[::-1]
        bRev = b[::-1]
        resRev = ""
        carry = "0"
        index = 0
        while index < len(aRev) or index < len(bRev):
            aBit = "0"
            bBit = "0"
            res = "0"
            if index < len(aRev):
                aBit = aRev[index]
            if index < len(bRev):
                bBit = bRev[index]
            index += 1
            if aBit == bBit:
                res = carry
                carry = "0"
                if aBit == "1":
                    carry = "1"
            else:
                if carry == "1":
                    res = "0"
                else:
                    res = "1"
            resRev += res

        if carry == "1":
            resRev += carry
        return resRev[::-1]
            
        