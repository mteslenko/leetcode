package leetcode.tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 *
 * @see <a href="https://leetcode.com/problems/unique-binary-search-trees/">Leetcode</a>
 */
class UniqueBinarySearchTreesRecursion {
  int numTrees(int n) {
    if (n == 0) {
      return 1;
    }
    if (n == 1) {
      return 1;
    }
    int sum = 0;
    Map<Integer, Integer> cache = new WeakHashMap<>();
    for (int i = 1; i <= n; i++) {
      int left = i - 1;
      int right = n - i;
      Integer leftCount = cache.computeIfAbsent(left, this::numTrees);
      Integer rightCount = cache.computeIfAbsent(right, this::numTrees);
      sum += leftCount * rightCount;
    }
    return sum;
  }

}
