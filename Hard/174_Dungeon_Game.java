class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
    	int [][] dp = new int [dungeon.length][dungeon[0].length]();
    	for (int i = 0; i < dungeon.length; i ++) {
    		dp[i][0] = Math.max(dp[i - 1][0], -1 * dungeon[i][0]);
    	}
    	for (int j = 0; j < dungeon[0].length; j ++) {
    		dp[0][j] = Math.max(dp[0][j - 1], -1 * dungeon[0][j]);
    	}
    	for (int i = 1; i < dungeon.length; i ++) {
    		for (int j = 1; j < dungeon[0].length; j ++) {
    			dp[i][j] = Math.max(Math.min(dp[i - 1][j], dp[i][j - 1]), -1 * dungeon[i][j]);

    		}
    	}
    }
}