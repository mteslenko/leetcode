package leetcode.tasks;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {
  public List<List<Integer>> getFactors(int n) {
    List<List<Integer>> res = new ArrayList<>();
    helper(n, res, new ArrayList<>(), 1, 2);
    return res;
  }

  private void helper(int n, List<List<Integer>> res,
      ArrayList<Integer> cur, int product, int start) {
    if (n == product) {
      res.add(new ArrayList<>(cur));
      return;
    }
    for (int i = start; i <= n / 2; i++) {
      if (product * i > n) {
        continue;
      }
      int ind = cur.size();
      cur.add(ind, i);
      helper(n, res, cur, product * i, i);
      cur.remove(ind);
    }
  }
}
