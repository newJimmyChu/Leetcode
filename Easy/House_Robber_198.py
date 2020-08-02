class Solution(object):
    def rob(self, nums):
        dp = [0 for x in range(len(nums))]
        if nums == []:
            return 0
        if len(nums) == 1:
            return nums[0]
        if len(nums) == 2:
            return max(nums[0], nums[1])
        dp[0] = nums[0]
        dp[1] = max(nums[1], nums[0])
        for i in range(2, len(nums)):
            dp[i] = max(nums[i] + dp[i - 2], dp[i - 1])
        return dp[len(nums)-1]