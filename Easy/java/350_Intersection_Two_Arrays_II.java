class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
    	if (nums1.length < nums2.length)
    		return intersect(nums2, nums1);

    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    	for (int num : nums1) {
    		if (map.containsKey(num)) {
    			Integer count = map.get(num);
    			map.put(num, count + 1);
    		}
    		else 
    			map.put(num, 1);
    	}

    	List<Integer> ret = new ArrayList<>();

    	for (int num : nums2) {
    		Integer count = 0;
    		if (map.containsKey(num))
    			count = map.get(num);
    		if (count > 0) {
    			ret.add(num);
    			map.put(num, count - 1);
    		}
    	}
    	int[] r = new int[ret.size()];
    	for (int i = 0; i < ret.size(); i++)
    		r[i] = ret.get(i);

    	return r;
    }
}

