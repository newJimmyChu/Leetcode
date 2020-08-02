class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	int j = m - 1, k = n - 1;
        for (int i = nums1.length - 1; i >= 0; i--) {
        	if (j == -1) {
        		nums1[i] = nums2[k];
        		k--;
        		continue;
        	} else if (k == -1) {
        		nums1[i] = nums1[j];
        		j--;
        		continue;
        	}

        	if (nums1[j] >= nums2[k]) {
        		nums1[i] = nums1[j];
        		j--;
        	} else {
        		nums1[i] = nums2[k];
        		k--;
        	}
        }
    }
}