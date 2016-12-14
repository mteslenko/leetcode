package leetcode.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 *
 * @see <a href="https://leetcode.com/problems/combination-sum/">Leetcode</a>
 */
class CombinationSum {
  List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> current = new ArrayList<>();
    Arrays.sort(candidates);
    combinationSum(candidates, target, 0, current, result);
    return result;
  }

  private void combinationSum(int[] candidates, int target, int j, List<Integer> current, List<List<Integer>> result) {
    if (target == 0) {
      result.add(new ArrayList<>(current));
    }
    for (int i = j; i < candidates.length; i++) {
      if (candidates[i] > target) {
        return;
      }
      current.add(candidates[i]);
      combinationSum(candidates, target - candidates[i], i, current, result);
      current.remove(current.size() - 1);
    }
  }
}
