class Solution(object):
    def uniquePaths(self, m, n):
        dp = [[1 for x in range(m)] for y in range(n)]
        for i in range(n):
            for j in range(m):
                if j == 0:
                    dp[i][0] = dp[i - 1][0]
                elif i == 0:
                    dp[0][j] = dp[0][j - 1]
                else:
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j]
        return dp[n - 1][m - 1]