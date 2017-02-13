package leetcode.tasks;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/climbing-stairs/">Leetcode</a>
 */
public class ClimbingStairs {
  private Map<Integer, Integer> cache = new HashMap<>();
  public int climbStairs(int n) {
    if(n < 0) {
      return 0;
    }
    if (n == 0) {
      return 1;
    }
    if(cache.get(n) != null) {
      return cache.get(n);
    }
    int result = climbStairs(n - 1) + climbStairs(n - 2);
    cache.put(n, result);
    return result;
  }
}
