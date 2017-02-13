package leetcode.tasks;

/**
 * @see <a href="https://leetcode.com/problems/unique-paths/">Leetcode</a>
 */
public class UniquePaths2 {
  public int uniquePathsWithObstacles(int[][] grid) {
    int c = grid[0].length;
    int r = grid.length;
    int[] dp = new int[c];
    if (grid[0][0] != 1) {
      dp[0] = 1;
    }
    for (int i = 1; i < c; i++) {
      dp[i] = grid[0][i] == 1 ? 0 : dp[i - 1];
    }
    for (int i = 1; i < r; i++) {
      if (grid[i][0] == 1) {
        dp[0] = 0;
      }
      for (int j = 1; j < c; j++) {
        if (grid[i][j] == 1) {
          dp[j] = 0;
        } else {
          if (j != 0) {
            dp[j] += dp[j - 1];
          }
        }
      }
    }
    return dp[c - 1];
  }
}
