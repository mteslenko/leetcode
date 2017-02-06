package leetcode.tasks;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/">Leetcode</a>
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
