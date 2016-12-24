package leetcode.tasks;

/**
 * Given an input string, reverse the string word by word.
 *
 * @see <a href="https://leetcode.com/problems/reverse-words-in-a-string/">Leetcode</a>
 */
class ReverseWordsInAString {
  String reverseWords(String s) {
    String[] words = s.split(" ");
    StringBuilder result = new StringBuilder();
    for (int i = words.length - 1; i >= 0; i--) {
      String next = words[i];
      if (!next.isEmpty()) {
        result.append(next).append(" ");
      }
    }
    if (result.length() > 0) {
      return result.substring(0, result.length() - 1);
    } else {
      return result.toString();
    }
  }
}
