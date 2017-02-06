package others.tasks;

import java.util.ArrayList;
import java.util.List;

/**
 * Print all string permutation
 */
public class StringPermutations {
  public List<String> permutation(String str) {
    List<String> result = new ArrayList<>();
    permutation(str, "", result);
    return result;
  }

  private void permutation(String str, String prefix, List<String> result) {
    if (str.isEmpty()) {
      result.add(prefix);
    }
    for (int i = 0; i < str.length(); i++) {
      String rem = str.substring(0, i) + str.substring(i + 1);
      permutation(rem, prefix + str.charAt(i), result);
    }
  }
}
