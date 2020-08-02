public class Solution {
    public boolean Find(int target, int [][] array) {
    	if (array == null || array.length == 0 || array[0].length == 0) {
    		return false;
    	}
    	int m = 0;
    	int n = array[0].length - 1;
    	while (m < array.length && n >= 0) {
			if (target == array[m][n]) {
    			return true;
    		} else if (target > array[m][n]) {
    			m++;
    		} else {
    			n--;
    		}
    	}
    	return false;
    	
    }
}