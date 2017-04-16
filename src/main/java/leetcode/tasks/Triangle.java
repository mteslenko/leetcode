package leetcode.tasks;

import java.util.Arrays;
import java.util.List;

public class Triangle {
  public int minimumTotal(List<List<Integer>> triangle) {
    int rows = triangle.size();
    int[][] dp = new int[rows][triangle.get(rows - 1).size()];
    dp[0][0] = triangle.get(0).get(0);
    for (int i = 1; i < rows; i++) {
      for (int j = 0; j < i + 1; j++) {
        dp[i][j] =
            triangle.get(i).get(j) +
                Math.min(
                    j == 0 ? Integer.MAX_VALUE : dp[i - 1][j - 1],
                    j == i ? Integer.MAX_VALUE : dp[i - 1][j]);
      }
    }
    return Arrays.stream(dp[rows - 1]).min().orElse(0);
  }

}
