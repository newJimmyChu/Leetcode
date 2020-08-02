class Solution {
    public int removeDuplicates(int[] nums) {
    	int ret = 0;
    	int i = 0, j = 1;
    	while (j < nums.length) {
    		if (nums[i] != nums[j]) {
    			nums[++i] = nums[j];
    		}
    		j++;
    	}
    	return i + 1;	
    }
}