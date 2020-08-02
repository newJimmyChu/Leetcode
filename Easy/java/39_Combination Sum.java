import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        successors(ret, candidates, target, 0, cur);
        return ret;
    }

    private void successors(List<List<Integer>> ret, int[] candidates, int target, int start, List<Integer> current) {
        if (target == 0) {
            ret.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < candidates.length; i ++) {
            if (candidates[i] <= target) {
                current.add(candidates[i]);
                successors(ret, candidates, target - candidates[i], i, current);
                current.remove(current.size() - 1);
            }
        }
    }
}
