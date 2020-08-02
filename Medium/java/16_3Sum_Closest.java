class Solution {
    public int threeSumClosest(int[] nums, int target) {
    	int min = Integer.MAX_VALUE;
    	Arrays.sort(nums);
    	for (int i = 0; i < nums.length; i ++) {
    		int j = i + 1, k = nums.length - 1;
    		while (j < k) {
    			int sub = target - nums[i] - nums[j] - nums[k];
    			if (sub == 0)
    				return target;
    			else if (sub > 0)
    				j ++;
    			else 
    				k --;
    			if (Math.abs(sub) < Math.abs(min))
    				min = sub;
    		}
    	}
    	return -(min - target);
    }
}