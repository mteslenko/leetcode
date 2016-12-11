package leetcode.tasks;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 *
 * @see <a href="https://leetcode.com/problems/unique-binary-search-trees/">Leetcode</a>
 */
class UniqueBinarySearchTreesArray {
  int numTrees(int n) {
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
}
