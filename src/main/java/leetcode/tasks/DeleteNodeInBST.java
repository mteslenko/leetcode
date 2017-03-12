package leetcode.tasks;

public class DeleteNodeInBST {
  public TreeNode deleteNode(TreeNode node, int key) {
    if (node == null) {
      return null;
    }
    if (key > node.val) {
      node.right = deleteNode(node.right, key);
    } else if (key < node.val) {
      node.left = deleteNode(node.left, key);
    } else {
      if (node.left != null && node.right != null) {
        TreeNode minNode = findMin(node.right);
        node.val = minNode.val;
        node.right = deleteNode(node.right, node.val);
      } else if (node.left == null) {
        return node.right;
      } else {
        return node.left;
      }
    }
    return node;
  }

  private TreeNode findMin(TreeNode root) {
    while (true) {
      if (root.left == null) {
        return root;
      } else {
        root = root.left;
      }
    }
  }
}
