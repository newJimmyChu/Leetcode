class Solution(object):
    def lengthOfLIS(self, nums):
        if nums == []:
            return 0
        dp = [0 for x in nums]
        for i in range(len(nums)):
            max_j = 1
            for j in range(0, i):
                if dp[j] + 1 > max_j and nums[j] < nums[i]:
                    max_j = dp[j] + 1
            dp[i] = max_j
        return max(dp)
