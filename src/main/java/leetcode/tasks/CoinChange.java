package leetcode.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * @see <a href="https://leetcode.com/problems/coin-change/">Leetcode</a>
 */
class CoinChange {
  private Map<Integer, Integer> minChange = new HashMap<>();

  int coinChange(int[] coins, int amount) {
    Arrays.sort(coins);
    for (int coin : coins) {
      minChange.put(coin, 1);
    }
    return findChange(coins, amount);
  }

  private int findChange(int[] coins, int amount) {
    if (amount < 0) {
      return -1;
    }
    if (amount == 0) {
      return 0;
    }
    if (minChange.get(amount) != null) {
      return minChange.get(amount);
    }
    List<Integer> attempts = new ArrayList<>(coins.length);
    for (int coin : coins) {
      int num = findChange(coins, amount - coin) + 1;
      if (num > 0) {
        attempts.add(num);
      }
    }
    Integer result = attempts.isEmpty() ? -1 : Collections.min(attempts);
    minChange.put(amount, result);
    return result;
  }
}
