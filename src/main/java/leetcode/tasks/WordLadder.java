package leetcode.tasks;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of
 * shortest transformation sequence from beginWord to endWord.
 *
 * @see <a href="https://leetcode.com/problems/word-ladder">Leetcode</a>
 */
class WordLadder {
  private static class Node {
    private final String value;
    private final int layer;

    Node(String value, int layer) {
      this.value = value;
      this.layer = layer;
    }
  }

  int ladderLength(String beginWord, String endWord, Set<String> wordList) {
    wordList.add(endWord);
    Queue<Node> queue = new LinkedList<>();
    Node beginNode = new Node(beginWord, 1);
    queue.add(beginNode);
    while (!queue.isEmpty()) {
      Node top = queue.remove();
      char[] cs = top.value.toCharArray();
      for (int i = 0; i < cs.length; i++) {
        char tmp = cs[i];
        for (char c = 'a'; c <= 'z'; c++) {
          cs[i] = c;
          String candidate = new String(cs);
          if (candidate.equals(endWord)) {
            return top.layer + 1;
          }
          if (wordList.contains(candidate)) {
            queue.add(new Node(candidate, top.layer + 1));
            wordList.remove(candidate);
          }
        }
        cs[i] = tmp;
      }
    }
    return 0;
  }
}
