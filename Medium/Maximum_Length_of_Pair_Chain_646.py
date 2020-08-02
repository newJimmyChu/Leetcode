class Solution(object):
    def findLongestChain(self, pairs):
        pairs.sort()
        dp = [1 for x in range(len(pairs))]
        for i in range(len(pairs)):
            max_j = 1
            for j in range(0, i):
                if pairs[j][1] < pairs[i][0] and max_j < dp[j] + 1:
                    max_j = dp[j] + 1
            dp[i] = max_j
        return max(dp)