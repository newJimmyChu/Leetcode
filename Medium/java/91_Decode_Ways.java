class Solution {
    public int numDecodings(String s) {
        return helper(s, 0);
    }

    private int helper(String s, int start) {
        if (start == s.length()) {
            return 1;
        }
        int ret = 0;
        int temp = 0;
        for (int i = start; i < s.length(); i ++) {
            if (s.charAt(i) != '0')
                ret += helper(s, i + 1);

            if (i < s.length() - 1)
                temp = Character.getNumericValue(s.charAt(i)) * 10 + Character.getNumericValue(s.charAt(i + 1));
            if (temp > 0 && temp <= 26)
                ret += helper(s, i + 2);
        }
        return ret;
    }
}


class Solution {
    public int numDecodings(String s) {
        if (s.length() == 1 && s.charAt(0) != '0')
            return 1;
        else if (s.length() == 1)
            return 0;

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(1) == '0'? 0 : 1;
        for (int i = 2; i < s.length() + 1; i ++) {
            if (s.charAt(i - 1) == '0')
                continue;
            else
                dp[i] += dp[i - 1];
            if (s.charAt(i - 2) != 0) {
                if (Integer.valueOf(s.substring(i - 2, i)) <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[s.length()];
    }
}
