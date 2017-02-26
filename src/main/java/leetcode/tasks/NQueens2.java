package leetcode.tasks;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/n-queens/">Leetcode</a>
 */
public class NQueens2 {
  public int totalNQueens(int n) {
    List<StringBuilder> board = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      StringBuilder row = new StringBuilder(n);
      for (int j = 0; j < n; j++) {
        row.append('.');
      }
      board.add(row);
    }
    return findSolutions(n, 0, board);
  }

  private int findSolutions(int remaining, int r, List<StringBuilder> board) {
    if (remaining == 0) {
      return 1;
    }
    int sum = 0;
    for (int c = 0; c < board.size(); c++) {
      if (validate(board, r, c)) {
        board.get(r).setCharAt(c, 'Q');
        sum += findSolutions(remaining - 1, r + 1, board);
        board.get(r).setCharAt(c, '.');
      }
    }
    return sum;
  }

  private boolean validate(List<StringBuilder> board, int r, int c) {
    int n = board.size();
    for (int i = 0; i <= r; i++) {
      for (int j = 0; j < n; j++) {
        if (board.get(i).charAt(j) == 'Q' && (j == c || r - c == i - j || r + c == i + j)) {
          return false;
        }
      }
    }
    return true;
  }
}
