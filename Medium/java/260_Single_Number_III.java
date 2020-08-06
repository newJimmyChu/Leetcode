class Solution {
    public int[] singleNumber(int[] nums) {
        int temp = 0;
        int[] ret = new int[2];
        for (int i = 0; i < nums.length; i ++) {
            temp ^= nums[i];
        }
        // Get the rightmost different (1) bit
        temp &= -temp;
        for (int i = 0; i < nums.length; i ++) {
            if ((nums[i] & temp) == 0)
                ret[0] ^= nums[i];
            else
                ret[1] ^= nums[i];
        }
        return ret;
    }
}
