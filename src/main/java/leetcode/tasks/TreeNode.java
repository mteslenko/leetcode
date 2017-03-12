package leetcode.tasks;

import org.jetbrains.annotations.Nullable;

public class TreeNode {
  public int val;
  @Nullable
  public TreeNode left;
  @Nullable
  public TreeNode right;

  public TreeNode(int x) {
    val = x;
  }

  public static TreeNode buildTree(Integer[] values) {
    if (values.length == 0) {
      return null;
    }
    TreeNode root = new TreeNode(values[0]);
    buildTree(root, values, 1);
    return root;
  }

  private static void buildTree(TreeNode root, Integer[] values, int i) {
    if (i >= values.length) {
      return;
    }

    root.left = values[i] == null ? null : new TreeNode(values[i]);
    buildTree(root.left, values, i * 2 + 1);
    if (i + 1 < values.length) {
      root.right = values[i + 1] == null ? null : new TreeNode(values[i + 1]);
      buildTree(root.right, values, (i + 1) * 2 + 1);
    }
  }

  @Override
  public String toString() {
    return "TreeNode[val=" + val + ", left=" + (left == null ?
        null :
        left.val) + ", right=" + (right == null ? null : right.val) + ']';
  }

  public TreeNode addLeft(int val) {
    left = new TreeNode(val);
    return this;
  }

  public TreeNode addRight(int val) {
    right = new TreeNode(val);
    return this;
  }
}
