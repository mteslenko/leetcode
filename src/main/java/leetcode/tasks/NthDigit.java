package leetcode.tasks;

/**
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 * Note:
 * n is positive and will fit within the range of a 32-bit signed integer (n < 231).
 *
 * @see <a href="https://leetcode.com/problems/nth-digit/">Leetcode</a>
 */
class NthDigit {
  int findNthDigit(int n) {
    int i = 1;
    while (n > 9 * Math.pow(10, i - 1) * i) {
      n -= 9 * Math.pow(10, i - 1) * i;
      i++;
    }
    int num = (int) Math.pow(10, i - 1) + (n - 1) / i;
    int r = (n - 1) % i;
    return Character.getNumericValue(String.valueOf(num).charAt(r));
  }
}
