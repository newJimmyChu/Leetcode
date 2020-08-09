class Solution {
    public boolean hasAlternatingBits(int n) {
        int temp = n ^ (n >> 1);
        if ((temp & (temp + 1)) == 0)
            return true;
        return false;
    }
}
