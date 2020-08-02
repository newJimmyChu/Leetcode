class Solution {
    public int totalHammingDistance(int[] nums) {
    	int sum = 0;
    	int temp = 0;
        for (int i = 0; i < 32; i++) {
        	temp = 0;
        	for (int j = 0; j < nums.length; j++) {
        		if (((nums[j] >> i) & 1) == 1) {
        			temp++;
        		}
        	}
        	sum += temp * (nums.length - temp);
        }
        return sum;
    }
}