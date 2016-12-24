package leetcode.tasks;

/**
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the
 * array.
 *
 * @see <a href="https://leetcode.com/problems/increasing-triplet-subsequence/">Leetcode</a>
 */
class IncreasingTripletSubsequence {
  boolean increasingTriplet(int[] nums) {
    if (nums.length < 3) {
      return false;
    }
    int smallest = Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE;
    for (int current : nums) {
      if (smallest >= current) {
        smallest = current;
      } else if (secondSmallest >= current) {
        secondSmallest = current;
      } else {
        return true;
      }
    }
    return false;
  }
}
