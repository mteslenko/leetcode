package leetcode.tasks;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
    buildTree(Collections.singletonList(root), values, 1);
    return root;
  }

  private static void buildTree(List<TreeNode> roots, Integer[] values, int i) {
    List<TreeNode> newRoots = new ArrayList<>();
    for (TreeNode root : roots) {

      if (i >= values.length) {
        return;
      }
      Integer nextVal = values[i++];
      root.left = nextVal == null ? null : new TreeNode(nextVal);
      if (i >= values.length) {
        return;
      }
      Integer nextRightVal = values[i++];
      root.right = nextRightVal == null ? null : new TreeNode(nextRightVal);

      if (root.left != null) {
        newRoots.add(root.left);
      }
      if (root.right != null) {
        newRoots.add(root.right);
      }
    }
    buildTree(newRoots, values, i);
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
