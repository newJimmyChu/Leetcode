import java.util.List;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0; i <= n; i ++) {
            for (String word : wordDict) {
                if (word.length() > i)
                    continue;
                if (s.substring(i - word.length(), i).equals(word)) {
                    dp[i] = dp[i] || dp[i - word.length()];
                }
            }
        }
        return dp[n];
    }
}
