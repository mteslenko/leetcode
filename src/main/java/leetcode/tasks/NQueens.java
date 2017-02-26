package leetcode.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @see <a href="https://leetcode.com/problems/n-queens/">Leetcode</a>
 */
public class NQueens {
  public List<List<String>> solveNQueens(int n) {
    List<StringBuilder> board = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      StringBuilder row = new StringBuilder(n);
      for (int j = 0; j < n; j++) {
        row.append('.');
      }
      board.add(row);
    }
    List<List<String>> result = new ArrayList<>();
    findSolutions(n, 0, board, result);
    return result;
  }

  private void findSolutions(int remaining, int r, List<StringBuilder> board,
      List<List<String>> result) {
    if (remaining == 0) {
      result.add(board.stream().map(StringBuilder::toString).collect(Collectors.toList()));
      return;
    }
    for (int c = 0; c < board.size(); c++) {
      if (validate(board, r, c)) {
        board.get(r).setCharAt(c, 'Q');
        findSolutions(remaining - 1, r + 1, board, result);
        board.get(r).setCharAt(c, '.');
      }
    }
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
