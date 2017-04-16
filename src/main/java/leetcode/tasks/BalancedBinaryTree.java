package leetcode.tasks;

import java.util.HashMap;
import java.util.Map;

public class BalancedBinaryTree {
  private Map<TreeNode, Integer> memo = new HashMap<>();

  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }
    boolean isBalanced = Math.abs(heightOf(root.left) - heightOf(root.right)) <= 1;
    return isBalanced && isBalanced(root.left) && isBalanced(root.right);
  }

  private int heightOf(TreeNode root) {
    if (root == null) {
      return 0;
    }
    if (memo.get(root) != null) {
      return memo.get(root);
    }
    int result = Math.max(heightOf(root.left), heightOf(root.right)) + 1;
    memo.put(root, result);
    return result;
  }
}
