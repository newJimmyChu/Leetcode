class Solution(object):
    def rob(self, nums):
        dp = [0 for x in range(len(nums))]
        if nums == []:
            return 0
        if len(nums) == 1:
            return nums[0]
        if len(nums) == 2:
            return max(nums[0], nums[1])
        if len(nums) == 3:
            return max(nums[0],  nums[2], nums[1])
        dp[0] = nums[0]
        dp[1] = max(nums[1], nums[0])
        for i in range(2, len(nums) - 1):
            dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])
        xp = [x for x in dp]
        xp[2] = max(nums[2], nums[1])
        for i in range(3, len(nums)):
            xp[i] = max(xp[i - 1], xp[i - 2] + nums[i])
        return max(xp[len(nums) - 1], dp[len(nums) - 2])