package leetcode.tasks;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the
 * largest sum.
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 *
 * @see <a href="https://leetcode.com/problems/maximum-subarray/">Leetcode</a>
 */
class BestTimeToBuyAndSellStock {
  public int maxProfit(int[] prices) {
    if (prices.length == 0) {
      return 0;
    }
    int max = 0;
    int minPrice = prices[0];
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] > prices[i - 1]) {
        max = Math.max(max, prices[i] - minPrice);
      } else {
        minPrice = Math.min(minPrice, prices[i]);
      }
    }
    return max;
  }
}
