package leetcode.tasks;

import org.jetbrains.annotations.NotNull;

public class WildcardMatching {
  public boolean isMatch(String s, String p) {
    if (s == null || p == null || (!s.isEmpty() && p.isEmpty())) {
      return false;
    }
    if (p.isEmpty()) {
      return s.isEmpty();
    }
    boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
    p = combineStars(p);
    dp[0][0] = true;
    if (p.charAt(0) == '*') {
      dp[0][1] = true;
      for (int i = 0; i < s.length(); i++) {
        dp[i][1] = true;
      }
    }
    for (int i = 0; i < s.length(); i++) {
      for (int j = 0; j < p.length(); j++) {
        boolean result = false;
        if (s.charAt(i) == p.charAt(j)) {
          result = dp[i][j];
        }
        if (p.charAt(j) == '?') {
          result = dp[i][j];
        }
        if (p.charAt(j) == '*') {
          result = dp[i + 1][j] || dp[i][j] || dp[i][j + 1];
        }
        dp[i + 1][j + 1] = result;
      }
    }
    return dp[s.length()][p.length()];
  }

  @NotNull
  private String combineStars(String p) {
    int l = 1;
    while (l < p.length()) {
      if (p.charAt(l) == '*' && p.charAt(l - 1) == '*') {
        p = p.substring(0, l) + p.substring(l + 1);
      } else {
        l++;
      }
    }
    return p;
  }
}
