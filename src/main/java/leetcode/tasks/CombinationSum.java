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
    Arrays.sort(candidates);
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> current = new ArrayList<>();
    combinationSum(candidates, target, 0, current, result);
    return result;
  }

  private void combinationSum(int[] candidates, int target, int i, List<Integer> current,
      List<List<Integer>> result) {
    if (target == 0) {
      result.add(new ArrayList<>(current));
    }
    for (int j = i; j < candidates.length; j++) {
      if (candidates[j] > target) {
        return;
      }
      current.add(candidates[j]);
      combinationSum(candidates, target - candidates[j], j, current, result);
      current.remove(current.size() - 1);
    }
  }
}
