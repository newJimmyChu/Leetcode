import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ret = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        helper(ret, s, cur);
        return ret;
    }

    private void helper(List<List<String>> ret, String s, List<String> cur) {
        if (s.length() == 0) {
            ret.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < s.length(); i ++) {
            if (isPalindrome(s, 0, i)) {
                cur.add(s.substring(0, i + 1));
                helper(ret, s.substring(i + 1), cur);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int begin, int end) {
        while (begin < end) {
            if (!(s.charAt(begin++) == s.charAt(end--)))
                return false;
        }
        return true;
    }
}
