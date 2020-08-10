class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        int highest = 1;
        int max = 0;
        dp[0] = 1;
        for (int i = 1; i < nums.length; i ++) {
            int j = i;
            highest = 1;
            while (j >= 0) {
                if (nums[j] < nums[i])
                    highest = Math.max(dp[j] + 1, highest);
                j --;
            }
            dp[i] = highest;
            max = Math.max(highest, max);
        }
        return max;
    }
}
