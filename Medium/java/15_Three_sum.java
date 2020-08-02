class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    	Set<List<Integer>> ret = new HashSet();
        Arrays.sort(nums);
        int c = 0, prevp = 0;
        for (int i = 0; i < nums.length - 2; i ++) {
        	int cur = nums[i];
        	int left = i + 1;
        	int right = nums.length - 1;

        	while (left < right) {
        		int sum = cur + nums[left] + nums[right];
        		if (sum == 0) {
        			Integer[] arr = new Integer[]{cur, nums[left++], nums[right--]};
        			ret.add(Arrays.asList(arr));
        		} 
        		else if (sum < 0)
      				left++;
      			else
      				right--;
        	}
        	
        }
        return new ArrayList<>(ret);
    }
}