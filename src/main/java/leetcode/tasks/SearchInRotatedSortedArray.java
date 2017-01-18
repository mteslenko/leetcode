package leetcode.tasks;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return
 * -1.
 *
 * @see <a href="https://leetcode.com/problems/search-in-rotated-sorted-array">Leetcode</a>
 */
class SearchInRotatedSortedArray {
  int search(int[] nums, int target) {
    if (nums.length == 1) {
      return nums[0] == target
          ? 0
          : -1;
    }
    int pivot = findPivot(nums);
    if (pivot == -1) {
      return bSearch(nums, target, 0, nums.length - 1);
    }
    int result = bSearch(nums, target, 0, pivot - 1);
    if (result == -1) {
      result = bSearch(nums, target, pivot, nums.length - 1);
    }
    return result;
  }

  private int bSearch(int[] nums, int target, int begin, int end) {
    if (end - begin == 0) {
      return nums[begin] == target
          ? begin
          : -1;
    }
    if (end - begin == 1) {
      if (nums[begin] == target) {
        return begin;
      } else {
        return nums[end] == target
            ? end
            : -1;
      }
    }
    int middle = begin + (end - begin) / 2;

    if (nums[middle] == target) {
      return middle;
    }

    return target < nums[middle]
        ? bSearch(nums, target, begin, middle)
        : bSearch(nums, target, middle, end);
  }

  private int findPivot(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      if (i > 0 && nums[i - 1] > nums[i]) {
        return i;
      }
    }
    return -1;
  }
}
