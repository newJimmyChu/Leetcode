class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] val = new int[n];
        int max = 0;
        for (int i = 0; i < n; i ++) {
            for (char c : words[i].toCharArray()) {
                val[i] |= 1 << (c - 'a');
            }
        }

        for (int i = 0; i < words.length; i ++) {
            for (int j = i + 1; j < words.length; j ++) {
                if ((val[i] & val[j]) == 0) {
                    int product = words[i].length() * words[j].length();
                    if (product > max) max = product;
                }
            }
        }
        return max;
    }
}
