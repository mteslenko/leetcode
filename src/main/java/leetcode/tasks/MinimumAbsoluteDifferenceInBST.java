package leetcode.tasks;

public class MinimumAbsoluteDifferenceInBST {
  public int getMinimumDifference(TreeNode root) {
    if (root == null || (root.left == null && root.right == null)) {
      return Integer.MAX_VALUE;
    }
    int leftMax = Integer.MAX_VALUE;
    if (root.left != null) {
      leftMax = findMax(root.left);
    }
    int rightMin = Integer.MAX_VALUE;
    if (root.right != null) {
      rightMin = findMin(root.right);
    }
    return Math.min(Math.min(
        Math.abs(root.val - leftMax),
        Math.abs(root.val - rightMin)), Math.min(
        getMinimumDifference(root.left),
        getMinimumDifference(root.right)));
  }

  private int findMax(TreeNode root) {
    while (root.right != null) {
      root = root.right;
    }
    return root.val;
  }

  private int findMin(TreeNode root) {
    while (root.left != null) {
      root = root.left;
    }
    return root.val;
  }

}
