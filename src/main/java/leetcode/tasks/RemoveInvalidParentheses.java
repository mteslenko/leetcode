package leetcode.tasks;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class RemoveInvalidParentheses {
  public List<String> removeInvalidParentheses(String s) {

    int p = 0;
    while (s.length() > p && s.charAt(p) != '(') {
      if (s.charAt(p) == ')') {
        s = s.substring(0, p) + s.substring(p + 1);
      } else {
        p++;
      }
    }

    Queue<String> q = new ArrayDeque<>();
    q.add(s);

    boolean found = false;

    List<String> results = new ArrayList<>();
    List<String> visited = new ArrayList<>();
    while (!q.isEmpty()) {
      String variant = q.remove();
      if (isValid(variant)) {
        results.add(variant);
        found = true;
      }

      if (found) {
        continue;
      }

      for (int i = 0; i < variant.length(); i++) {
        char ch = variant.charAt(i);
        if (ch == ')' || ch == '(') {
          String t = variant.substring(0, i) + variant.substring(i + 1);
          if (!visited.contains(t)) {
            visited.add(t);
            q.add(t);
          }
        }
      }
    }
    return results;
  }

  private boolean isValid(String s) {
    int stack = 0;
    for (char ch : s.toCharArray()) {
      if (ch == '(') {
        stack++;
      }
      if (ch == ')') {
        stack--;
      }
      if (stack < 0) {
        return false;
      }
    }
    return stack == 0;
  }
}
