class Solution(object):
    def wiggleMaxLength(self, nums):
        if nums == []:
            return 0
        if len(nums) == 1:
            return 1
        dp = [0 for x in nums]
        if nums[1] - nums[0] > 0:
            dp[1] = 2
        if nums[1] - nums[0] < 0:
            dp[1] = -2
        for i in range(2, len(nums)):
            max_j = 0
            for j in range(1, i):
                temp = (nums[i] - nums[j])
                if abs(max_j) < abs(dp[j]) + 1:
                    if temp < 0 and dp[j] > 0:
                        max_j = -1 - dp[j]
                    elif temp > 0 and dp[j] < 0:
                        max_j = 1 - dp[j]
            dp[i] = max_j
        return abs(max(dp, key=lambda x: abs(x)))