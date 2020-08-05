import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        helper(nums, ret, visited, cur, 0);
        ret.add(new ArrayList<>());
        return ret;
    }

    private void helper(int[] nums, List<List<Integer>> ret, boolean[] visited, List<Integer> cur, int start) {
        for (int i = start; i < nums.length; i ++) {
            if (i >= 1 && visited[i - 1] == false && nums[i] == nums[i - 1])
                continue;
            cur.add(nums[i]);
            ret.add(new ArrayList<>(cur));
            visited[i] = true;
            helper(nums, ret, visited, cur, i + 1);
            visited[i] = false;
            cur.remove(cur.size() - 1);
        }
    }
}
