package leetcode.tasks;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 *
 * @see <a href="https://leetcode.com/problems/unique-binary-search-trees/">Leetcode</a>
 */
class UniqueBinarySearchTrees {
  int numTrees_bottomUp(int n) {
    if (n == 0) {
      return 1;
    }
    int[] count = new int[n + 1];
    count[0] = 1;
    count[1] = 1;
    for (int i = 2; i <= n; i++) {
      int sum = 0;
      for (int j = 0; j < i; j++) {
        sum += count[j] * count[i - j - 1];
      }
      count[i] = sum;
    }
    return count[n];
  }

  private Map<Integer, Integer> cache = new WeakHashMap<>();
  int numTrees_topDown(int n) {
    if (n == 0) {
      return 1;
    }
    if (n == 1) {
      return 1;
    }
    int sum = 0;
    for (int i = 1; i <= n; i++) {
      int left = i - 1;
      int right = n - i;
      Integer leftCount = cache.computeIfAbsent(left, this::numTrees_topDown);
      Integer rightCount = cache.computeIfAbsent(right, this::numTrees_topDown);
      sum += leftCount * rightCount;
    }
    return sum;
  }

}
