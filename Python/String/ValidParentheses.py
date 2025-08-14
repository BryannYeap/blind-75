class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        bracketMap = {'(' : ')', '[' : ']', '{' : '}'}
        for substr in s:
            if substr == '(' or substr == '[' or substr == '{': 
                stack.append(substr)
            else:
                if len(stack) == 0:
                    return False
                openStr = stack.pop()
                if bracketMap[openStr] != substr:
                    return False
        return len(stack) == 0
