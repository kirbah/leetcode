/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int[] candidates, int index, int target, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
        } else if (target > 0) {
            for (int i = index; i < candidates.length; i++) {
                current.add(candidates[i]);
                dfs(candidates, i, target - candidates[i], current, result);
                current.remove(current.size() - 1);
            }
        }
    }
}
// @lc code=end

