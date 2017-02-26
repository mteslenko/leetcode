package leetcode.tasks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/subsets/?tab=Description">Leetcode</a>
 */
public class Subsets {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> subs = new ArrayList<>();

    int n = 1 << nums.length;
    for (int i = 0; i < n; i++) {
      List<Integer> sub = new ArrayList<>();
      int s = i;
      int k = 0;
      while (s > 0) {
        if ((s & 1) == 1) {
          sub.add(nums[k]);
        }
        s >>= 1;
        k++;
      }
      subs.add(sub);
    }
    return subs;
  }


  public List<List<Integer>> subsetsRecursion(int[] nums) {
    return subsetsRecursion(nums, 0);
  }

  private List<List<Integer>> subsetsRecursion(int[] nums, int i) {
    if (i == nums.length) {
      List<List<Integer>> emptySubset = new ArrayList<>();
      emptySubset.add(new ArrayList<>());
      return emptySubset;
    }
    List<List<Integer>> subsets = subsetsRecursion(nums, i + 1);
    List<List<Integer>> newSubsets = new ArrayList<>();
    for (List<Integer> subset : subsets) {
      LinkedList<Integer> newSubset = new LinkedList<>(subset);
      newSubset.addFirst(nums[i]);
      newSubsets.add(newSubset);
    }
    subsets.addAll(newSubsets);
    return subsets;
  }
}
