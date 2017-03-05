package leetcode.tasks;

public class MaximalSquare {
  public int maximalSquare(char[][] matrix) {
    if (matrix.length == 0) {
      return 0;
    }
    int maxArea = 0;
    int[][] max = new int[matrix.length + 1][matrix[0].length + 1];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == '1') {
          max[i + 1][j + 1] = Math.min(Math.min(max[i][j + 1], max[i][j]), max[i + 1][j]) + 1;
          maxArea = Math.max(maxArea, max[i + 1][j + 1]);
        }
      }
    }
    return maxArea * maxArea;
  }
}
