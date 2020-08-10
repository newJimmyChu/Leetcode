import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int findLongestChain(int[][] pairs) {
        if (pairs.length == 0)
            return 0;
        int[] dp = new int[pairs.length];
        dp[0] = 1;
        int max = 1;
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[0]));
        for (int i = 1; i < pairs.length; i ++) {
            int highest = 1;
            int j = i;
            while (j >= 0) {
                if (pairs[j][1] < pairs[i][0])
                    highest = Math.max(highest, dp[j] + 1);
                j --;
            }
            dp[i] = highest;
            max = Math.max(max, highest);
        }
        return max;
    }
}
