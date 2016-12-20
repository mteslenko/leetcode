package leetcode.tasks;

/**
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of
 * haystack.
 *
 * @see <a href="https://leetcode.com/problems/implement-strstr/">Leetcode</a>
 */
class ImplementStrStr {
  int strStr(String haystack, String needle) {
    if (needle.isEmpty()) {
      return 0;
    }
    for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
      if (haystack.charAt(i) == needle.charAt(0)) {
        int end = i + needle.length();
        int j = i + 1;
        while (j < end && haystack.charAt(j) == needle.charAt(j - i)) {
          j++;
        }
        if (j == end) {
          return i;
        }
      }
    }
    return -1;
  }
}
