package leetcode.tasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique
 * permutations.
 *
 * @see <a href="https://leetcode.com/problems/permutations-ii/">Leetcode</a>
 */
public class Permutations2 {
  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Map<Integer, Integer> freq = buildFreq(nums);
    permuteUnique(freq, new ArrayList<>(), nums.length, result);
    return result;
  }

  private void permuteUnique(Map<Integer, Integer> freq, List<Integer> prefix, int remaining,
      List<List<Integer>> result) {
    if (remaining == 0) {
      result.add(prefix);
      return;
    }
    for (Entry<Integer, Integer> num : freq.entrySet()) {
      if (num.getValue() > 0) {
        List<Integer> newPrefix = new ArrayList<>(prefix);
        newPrefix.add(num.getKey());
        freq.replace(num.getKey(), num.getValue(), num.getValue() - 1);
        permuteUnique(freq, newPrefix, remaining - 1, result);
        freq.replace(num.getKey(), num.getValue(), num.getValue() + 1);
      }
    }
  }

  private Map<Integer, Integer> buildFreq(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      Integer value = map.getOrDefault(num, 0);
      map.put(num, value + 1);
    }
    return map;
  }

  public List<List<Integer>> permuteUniqueNotOptimized(int[] nums) {
    Set<List<Integer>> permutations = new LinkedHashSet<>();
    permutePrefix(IntStream.of(nums).boxed().collect(Collectors.toList()),
        new ArrayList<>(),
        permutations);
    return new ArrayList<>(permutations);
  }

  private void permutePrefix(List<Integer> nums, List<Integer> prefix,
      Set<List<Integer>> permutations) {
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
