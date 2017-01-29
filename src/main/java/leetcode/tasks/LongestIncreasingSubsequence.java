package leetcode.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * @see <a href="https://leetcode.com/problems/longest-increasing-subsequence">Leetcode</a>
 */
class LongestIncreasingSubsequence {
  int lengthOfLIS(int[] nums) {
    List<Integer> longestSub = new ArrayList<>();
    for (int num : nums) {
      if (longestSub.isEmpty() || num > longestSub.get(longestSub.size() - 1)) {
        longestSub.add(num);
      } else {
        int idx = Collections.binarySearch(longestSub, num);
        if (idx < 0) {
          longestSub.set(-idx - 1, num);
        }
      }
    }
    return longestSub.size();
  }

  int lengthOfLIS_DP(int[] nums) {
    int max[] = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      max[i] = 1;
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
          max[i] = Math.max(max[i], max[j] + 1);
        }
      }
    }
    return Arrays.stream(max).max().orElseGet(() -> 0);
  }
}
