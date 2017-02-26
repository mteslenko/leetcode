package leetcode.tasks;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/generate-parentheses/">Leetcode</a>
 */
public class GenerateParentheses {
  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    gen(n, 0, 0, "", result);
    return result;
  }

  private void gen(int n, int opened, int closed, String prefix, List<String> result) {
    if (opened > n || closed > opened) {
      return;
    }
    if (opened == n && closed == n) {
      result.add(prefix);
      return;
    }
    gen(n, opened + 1, closed, prefix + '(', result);
    gen(n, opened, closed + 1, prefix + ')', result);
  }
}
