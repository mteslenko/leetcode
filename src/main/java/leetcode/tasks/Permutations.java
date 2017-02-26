package leetcode.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Given a collection of distinct numbers, return all possible permutations.
 *
 * @see <a href="https://leetcode.com/problems/permutations/">Leetcode</a>
 */
public class Permutations {
  public List<List<Integer>> permuteInsert(int[] nums) {
    List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
    if (numList.size() == 1) {
      List<List<Integer>> permutations = new ArrayList<>();
      permutations.add(new ArrayList<>(numList));
      return permutations;
    }
    int num = numList.get(0);
    List<Integer> subList = numList.subList(1, numList.size());
    List<List<Integer>> subPermutations = permuteInsert(subList.stream()
        .mapToInt(i -> i)
        .toArray());
    List<List<Integer>> permutations = new ArrayList<>();
    for (List<Integer> subPermutation : subPermutations) {
      for (int k = 0; k < subPermutation.size() + 1; k++) {
        List<Integer> newPermutation = new LinkedList<>(subPermutation);
        newPermutation.add(k, num);
        permutations.add(newPermutation);
      }
    }
    return permutations;
  }

  public List<List<Integer>> permutePrefix(int[] nums) {
    List<List<Integer>> permutations = new ArrayList<>();
    permutePrefix(IntStream.of(nums).boxed().collect(Collectors.toList()),
        new ArrayList<>(),
        permutations);
    return permutations;
  }

  private void permutePrefix(List<Integer> nums, List<Integer> prefix,
      List<List<Integer>> permutations) {
    if (nums.isEmpty()) {
      permutations.add(new ArrayList<>(prefix));
    }
    for (int i = 0; i < nums.size(); i++) {
      List<Integer> rem = new ArrayList<>(nums.subList(0, i));
      rem.addAll(nums.subList(i + 1, nums.size()));
      List<Integer> newPrefix = new ArrayList<>(prefix);
      newPrefix.add(nums.get(i));
      permutePrefix(rem, newPrefix, permutations);
    }
  }
}
