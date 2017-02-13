package leetcode.tasks;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/unique-paths/">Leetcode</a>
 */
public class UniquePaths {
  private Map<Point, Integer> cache = new HashMap<>();

  public int bottomUp(int r, int c) {
    int[] dp = new int[c];
    for (int i = 0; i < c; i++) {
      dp[i] = 1;
    }
    for (int i = 1; i < r; i++) {
      for (int j = 1; j < c; j++) {
        dp[j] += dp[j - 1];
      }
    }
    return dp[c - 1];
  }

  public int topDown(int r, int c) {
    if (r == 1) {
      return 1;
    }
    if (c == 1) {
      return 1;
    }
    Point point = new Point(r, c);
    Integer cached = cache.get(point);
    if (cached != null) {
      return cached;
    }
    int result = topDown(r - 1, c) + topDown(r, c - 1);
    cache.put(point, result);
    return result;
  }


}
