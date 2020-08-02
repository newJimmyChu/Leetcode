import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if (n < k)
            return new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        successors(n, k, 0, current, ret);
        return ret;
    }

    private void successors(int n, int k, int start, List<Integer> current, List<List<Integer>> ret) {
        if (current.size() == k) {
            ret.add(current);
            return;
        }
        for (int i = start + 1; i <= n; i ++) {
            List<Integer> newCurrent = new ArrayList<>(current);
            newCurrent.add(i);
            successors(n, k, i, newCurrent, ret);
        }
    }
}
