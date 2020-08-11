class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 0)
            return 0;
        int sum = 0;
        for (int i : nums)
            sum += i;
        sum = sum + S;
        if (sum % 2 != 0)
            return 0;

        sum = sum / 2;
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i ++) {
            for (int j = sum; j >= nums[i]; j --) {
                dp[j] = dp[j] + dp[j - nums[i]];
            }
        }
        return dp[sum];
    }
}
