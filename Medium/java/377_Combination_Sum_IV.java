class Solution {
    public int combinationSum4(int[] nums, int target) {
        if (nums.length == 0 || target == 0) {
            return 0;
        }
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i ++) {
            for (int j : nums) {
                if (j > i)
                    continue;
                dp[i] += dp[i - j];
            }
        }
        return dp[target];
    }
}
