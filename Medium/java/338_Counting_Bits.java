class Solution {
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 0;
        for (int i = 0; i < num + 1; i ++) {
            dp[i] = dp[i & (i - 1)] + 1;
        }
        return dp;
    }
}
