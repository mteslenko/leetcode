package leetcode.tasks;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
  private Map<Character, Integer> memo = new HashMap<>();

  public int lengthOfLongestSubstring(String s) {
    if (s.isEmpty()) {
      return 0;
    }
    int[] dp = new int[s.length()];
    dp[0] = 1;
    memo.put(s.charAt(0), 0);
    int p = 0;
    int max = 1;
    for (int i = 1; i < s.length(); i++) {
      char ch = s.charAt(i);
      Integer pos = memo.get(ch);
      if (pos == null || pos < p) {
        dp[i] = Math.max(dp[i - 1], i - p + 1);
      } else {
        dp[i] = Math.max(dp[i - 1], i - pos);
        p = pos + 1;
      }
      memo.put(ch, i);
      max = Math.max(max, dp[i]);
    }
    return max;
  }
}
