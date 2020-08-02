import math

class Solution(object):
    def integerBreak(self, n):
        if n == 0:
            return 0
        if n == 1 or n == 2:
            return 1
        if n == 3:
            return 2
        dp = [0 for i in range(n + 1)]
        dp[1] = 1
        dp[2] = 2
        dp[3] = 3
        for i in range(4, n + 1):
            dp[i] = helper(dp, i)
        return dp[n]


def helper(dp, n):
    max = 0
    for i in range(1, int(math.floor(n / 2)) + 1):
        t = dp[i] * dp[n - i]
        if t > max:
            max = t
    return max
