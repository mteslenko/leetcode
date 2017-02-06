package leetcode.tasks;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 *
 * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/">Leetcode</a>
 */
class BestTimeToBuyAndSellStock3 {
  public int maxProfit(int[] prices) {
    if (prices.length == 0) {
      return 0;
    }
    int buy1 = -Integer.MAX_VALUE;
    int sell1 = -Integer.MAX_VALUE;
    int buy2 = -Integer.MAX_VALUE;
    int sell2 = -Integer.MAX_VALUE;
    for (int price : prices) {
      buy1 = Math.max(buy1, -price);
      sell1 = Math.max(sell1, buy1 + price);
      buy2 = Math.max(buy2, sell1 - price);
      sell2 = Math.max(sell2, buy2 + price);
    }
    return sell2;
  }
}
