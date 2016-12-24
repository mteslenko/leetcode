package leetcode.tasks;

/**
 * Write a function to compute the next state (after one update) of the board given its current
 * state.
 *
 * @see <a href="https://leetcode.com/problems/game-of-life/">Leetcode</a>
 */
class GameOfLife {
  void gameOfLife(int[][] board) {
    int[][] result = new int[board.length][board[0].length];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        int count = countNeighbours(board, i, j);
        if (count == 2) {
          result[i][j] = board[i][j];
        } else if (count == 3) {
          result[i][j] = 1;
        } else {
          result[i][j] = 0;
        }
      }
    }
    for (int i = 0; i < result.length; i++) {
      System.arraycopy(result[i], 0, board[i], 0, result[i].length);
    }
  }

  private int countNeighbours(int[][] board, int i, int j) {
    int count = 0;
    for (int x = i - 1; x <= i + 1; x++) {
      if (x >= 0 && x < board.length) {
        for (int y = j - 1; y <= j + 1; y++) {
          if (y >= 0 && y < board[i].length && !(x == i && y == j)) {
            count += board[x][y];
          }
        }
      }
    }
    return count;
  }
}
