package leetcode.tasks;

import java.util.Arrays;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the
 * largest sum.
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 *
 * @see <a href="https://leetcode.com/problems/maximum-subarray/">Leetcode</a>
 */
class MaximumSubarray {
  int maxSubArray(int[] nums) {
    int prevSum = nums[0];
    int max = nums[0];
    for (int i = 1; i < nums.length; i++) {
      int num = nums[i];
      prevSum = Math.max(num, prevSum + num);
      max = Math.max(max, prevSum);
    }
    return max;
  }
}
