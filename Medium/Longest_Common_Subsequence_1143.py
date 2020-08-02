class Solution(object):
    def longestCommonSubsequence(self, text1, text2):
        text1 = list(text1)
        text2 = list(text2)
        if text1 == [] or text2 == []:
            return 0
        dp = [[0 for x in range(len(text2) + 1)] for y in range(len(text1) + 1)]
        for i in range(1, len(text1) + 1):
            for j in range(1, len(text2) + 1):
                if text1[i - 1] == text2[j - 1]:
                    dp[i][j] = dp[i - 1][j - 1] + 1
                else:
                    dp = max(dp[i - 1][j], dp[i][j - 1])
        return dp[len(text2)][len(text1)]