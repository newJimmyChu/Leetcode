// time: O(n)
// space: O(n)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] hash = new int [nums.length + 1];
        ArrayList<Integer> ret = new ArrayList<>();
        for (int i = 0; i < nums.length; i ++) {
        	hash[nums[i]] = 1;
        }
        for (int i = 1; i < nums.length + 1; i ++) { 
        	if (hash[i] == 0) {
        		ret.add(i);
        	}
        }
        return ret;
    }
}


class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
    	ArrayList<Integer> ret = new ArrayList<>();
    	for (int i = 0; i < nums.length; i ++) {
    		while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
    			int temp = nums[i];
    			nums[i] = nums[nums[i] - 1];
    			nums[nums[i] - 1] = temp;
    		}
    	}

    	for (int i = 0; i < nums.length; i ++) {
    		if (nums[i] != i + 1) {
    			ret.add(i + 1);
    		} 
    	}
    	return ret;
   	}
}