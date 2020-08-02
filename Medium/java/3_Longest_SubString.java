class Solution {
    public int lengthOfLongestSubstring(String s) {
    	Set<Character> set = new HashSet<>();
    	int position = 0;
    	int max = 0;
    	for (int i = 0; i < s.length(); i ++ ) {
    		char c = s.charAt(i);
    		
    		for (int j = position; j < s.length(); j ++) {
    			if (set.contains(s.charAt(j))) {
    				position = j;
    				max = Math.max(max, j - i);
    				set.remove(s.charAt(i));
    				break;
    			} else {
    				set.add(s.charAt(j));
    				position++;
    			}
    		}
    	}
    	return Math.max(max, set.size());
    }
}