package leetcode.tasks;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {
  private Map<String, Boolean> memo = new HashMap<>();

  public boolean wordBreak(String s, List<String> wordDict) {
    wordDict.sort((a, b) -> b.length() - a.length());
    return findWordBreak(s, wordDict);
  }

  private boolean findWordBreak(String s, List<String> wordDict) {
    if (s.isEmpty()) {
      return true;
    }
    if (memo.get(s) != null) {
      return memo.get(s);
    }

    for (String w : wordDict) {
      if (s.startsWith(w)) {
        String newString = s.substring(w.length());
        if (findWordBreak(newString, wordDict)) {
          memo.put(newString, true);
          return true;
        }
      }
    }
    memo.put(s, false);
    return false;
  }
}
