package leetcode.tasks;

public class RegularExpressionMatching {
  public boolean isMatch(String s, String p) {
    if (s == null || p == null) {
      return false;
    }
    boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
    dp[0][0] = true;
    for (int i = 0; i < p.length(); i++) {
      if (p.charAt(i) == '*' && dp[0][i - 1]) {
        dp[0][i + 1] = true;
      }
    }
    for (int i = 0; i < s.length(); i++) {
      for (int j = 0; j < p.length(); j++) {
        boolean result = false;
        if (s.charAt(i) == p.charAt(j)) {
          result = dp[i][j];
        }
        if (p.charAt(j) == '.') {
          result = dp[i][j];
        }
        if (p.charAt(j) == '*') {
          if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
            result = dp[i + 1][j - 1];
          } else {
            result = (dp[i][j + 1] || dp[i + 1][j] || dp[i + 1][j - 1]);
          }
        }
        dp[i + 1][j + 1] = result;
      }
    }
    return dp[s.length()][p.length()];
  }
}
