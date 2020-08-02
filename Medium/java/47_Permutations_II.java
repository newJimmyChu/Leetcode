import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0)
            return new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        successors(ret, nums, cur, visited);
        return ret;
    }

    private void successors(List<List<Integer>> ret, final int[] nums, List<Integer> cur, boolean[] visited) {
        if (cur.size() == nums.length) {
            ret.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i ++) {
            if (i != 0 && !visited[i - 1] && nums[i] == nums[i - 1])
                continue;
            if (visited[i])
                continue;

            visited[i] = true;
            cur.add(nums[i]);
            System.out.println(nums[i]);
            successors(ret, nums, cur, visited);
            cur.remove(cur.size() - 1);
            visited[i] = false;
        }

    }
}
