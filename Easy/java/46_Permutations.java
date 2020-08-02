import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        List<Integer> rem = Arrays.stream(nums).boxed().collect(Collectors.toList());
        successors(nums.length, cur, rem, ret);
        return ret;
    }

    private void successors(int len, List<Integer> current, List<Integer> rem, List<List<Integer>> ret) {
        if (len == current.size()) {
            ret.add(new ArrayList<>(current));
            return;
        }
        for (Integer i : rem) {
            ArrayList<Integer> newRemList = new ArrayList<>(rem);
            ArrayList<Integer> newCurrentList = new ArrayList<>(current);
            newRemList.remove(i);
            newCurrentList.add(i);
            successors(len, newCurrentList, newRemList, ret);
        }
    }
}
