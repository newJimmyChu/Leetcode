import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        ret.add(new ArrayList<>());
        helper(nums, ret, 0, cur);
        return ret;
    }

    private void helper(int[] nums, List<List<Integer>> ret, int start, List<Integer> cur) {
        for (int i = start; i < nums.length; i ++) {
            cur.add(nums[i]);
            ret.add(new ArrayList(cur));
            helper(nums, ret, i + 1, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
