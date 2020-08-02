class Solution {
    public int arrangeCoins(int n) {
    	int i = 1;
        while (n >= 0) {
        	n -= i++;
        }
        return i - 2;
    }
}