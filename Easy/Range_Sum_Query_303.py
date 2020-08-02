class NumArray(object):

    def __init__(self, nums):
        if nums == [] or nums == [[]]:
            return
        self.dp = [0 for x in nums]
        self.dp[0] = nums[0]
        for i in range(1, len(nums)):
            self.dp[i] = self.dp[i - 1] + nums[i]

    def sumRange(self, i, j):
        if i == 0:
            return self.dp[j]
        return self.dp[j] - self.dp[i - 1]