package leetcode.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Given a collection of distinct numbers, return all possible permutations.
 *
 * @see <a href="https://leetcode.com/problems/permutations/">Leetcode</a>
 */
public class Permutations {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> permutations = new ArrayList<>();
    permute(IntStream.of(nums).boxed().collect(Collectors.toList()),
        new ArrayList<>(),
        permutations);
    return permutations;
  }

  private void permute(List<Integer> nums, List<Integer> prefix, List<List<Integer>> permutations) {
    if (nums.isEmpty()) {
      permutations.add(new ArrayList<>(prefix));
    }
    for (int i = 0; i < nums.size(); i++) {
      List<Integer> rem = new ArrayList<>(nums.subList(0, i));
      rem.addAll(nums.subList(i + 1, nums.size()));
      List<Integer> newPrefix = new ArrayList<>(prefix);
      newPrefix.add(nums.get(i));
      permute(rem, newPrefix, permutations);
    }
  }
}
