class Solution(object):
    def climbStairs(self, n):
        if n == 0 or n == 1:
            return 1
        dp = [1 for x in range(n)]
        for i in range(2, n + 1):
            dp[i] = dp[i-1] + dp[i-2]
        return dp[n]
