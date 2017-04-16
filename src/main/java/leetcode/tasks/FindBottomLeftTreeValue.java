package leetcode.tasks;

public class FindBottomLeftTreeValue {
  public int findBottomLeftValue(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Result result = new Result(root.val, 0);
    findBottomLeftValue(root, 0, result);
    return result.val;
  }

  private void findBottomLeftValue(TreeNode root, int level, Result result) {
    if (root.left != null) {
      findBottomLeftValue(root.left, level + 1, result);
    }
    if (level > result.level) {
      result.level = level;
      result.val = root.val;
    }
    if (root.right != null) {
      findBottomLeftValue(root.right, level + 1, result);
    }
  }

  private static final class Result {
    private int val;
    private int level;

    private Result(int val, int level) {
      this.val = val;
      this.level = level;
    }
  }
}
