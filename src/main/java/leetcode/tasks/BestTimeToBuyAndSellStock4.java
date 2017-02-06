package leetcode.tasks;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 *
 * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/">Leetcode</a>
 */
class BestTimeToBuyAndSellStock4 {
  private static final int BUY = 0;
  private static final int SELL = 1;

  public int maxProfit(int k, int[] prices) {
    if (k > prices.length / 2) {
      return quickSolve(prices);
    }
    if (prices.length == 0) {
      return 0;
    }
    int[][] states = new int[k + 1][2];
    for (int i = 0; i < states.length; i++) {
      for (int j = 0; j < states[i].length; j++) {
        if (i == 0) {
          states[0][j] = 0;
        } else {
          states[i][j] = -Integer.MAX_VALUE;
        }
      }
    }
    for (int price : prices) {
      for (int i = 1; i <= k; i++) {
        states[i][BUY] = Math.max(states[i][BUY], states[i - 1][SELL] - price);
        states[i][SELL] = Math.max(states[i][SELL], states[i][BUY] + price);
      }
    }
    return states[k][1];
  }

  private int quickSolve(int[] prices) {
    int profit = 0;
    for (int i = 1; i < prices.length; i++) {
      profit += prices[i] - prices[i - 1] > 0 ? prices[i] - prices[i - 1] : 0;
    }
    return profit;
  }
}
