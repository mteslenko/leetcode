package leetcode.tasks;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent"
 * cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 *
 * @see <a href="https://leetcode.com/problems/word-search/">Leetcode</a>
 */
class WordSearch {
  boolean exist(char[][] board, String word) {
    char[] wordChars = word.toCharArray();
    for (int i = 0; i < board.length; i++) {
      char[] chars = board[i];
      for (int j = 0; j < chars.length; j++) {
        char aChar = chars[j];
        if (aChar == wordChars[0]) {
          char prev = board[i][j];
          board[i][j] = '-';
          if (dfs(board, wordChars, i, j, 1)) {
            return true;
          }
          board[i][j] = prev;
        }
      }
    }
    return false;
  }

  private boolean dfs(char[][] board, char[] wordChars, int x, int y, int k) {
    if (k == wordChars.length) {
      return true;
    }
    if (x - 1 >= 0 && board[x - 1][y] == wordChars[k]) {
      char prev = board[x - 1][y];
      board[x - 1][y] = '-';
      if (dfs(board, wordChars, x - 1, y, k + 1)) {
        return true;
      }
      board[x - 1][y] = prev;
    }
    if (x + 1 < board.length && board[x + 1][y] == wordChars[k]) {
      char prev = board[x + 1][y];
      board[x + 1][y] = '-';
      if (dfs(board, wordChars, x + 1, y, k + 1)) {
        return true;
      }
      board[x + 1][y] = prev;
    }
    if (y - 1 >= 0 && board[x][y - 1] == wordChars[k]) {
      char prev = board[x][y - 1];
      board[x][y - 1] = '-';
      if (dfs(board, wordChars, x, y - 1, k + 1)) {
        return true;
      }
      board[x][y - 1] = prev;
    }
    if (y + 1 < board[x].length && board[x][y + 1] == wordChars[k]) {
      char prev = board[x][y + 1];
      board[x][y + 1] = '-';
      if (dfs(board, wordChars, x, y + 1, k + 1)) {
        return true;
      }
      board[x][y + 1] = prev;
    }
    return false;
  }
}
