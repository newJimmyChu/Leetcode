class Solution {
    public int findComplement(int num) {
        int high = Integer.highestOneBit(num);
        high = (high << 1) - 1;
        return num ^ high;
    }
}
