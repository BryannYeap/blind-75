class Solution:
    
    global memo

    def climbStairs(self, n: int) -> int:
        self.memo = (n + 1) * [-1]
        self.memo[n - 1] = 1
        self.memo[n - 2] = 2
        return self.recur(0)
        
    def recur(self, n: int) -> int:
        if n >= len(self.memo):
            return 0
        
        if self.memo[n] != -1:
            return self.memo[n]
        
        res = self.recur(n + 1) + self.recur(n + 2)
        self.memo[n] = res
        return res

# Iterative

class Solution:
    
    global memo

    def climbStairs(self, n: int) -> int:
        self.memo = (n + 1) * [-1]
        self.memo[n - 1] = 1
        self.memo[n - 2] = 2
        for i in range(n-3, -1, -1):
            self.memo[i] = self.memo[i+1] + self.memo[i+2]

        return self.memo[0]