package leetcode.tasks;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class InvertBinaryTreeTest {
  @Test
  public void invertTree() {
    TreeNode tree = new TreeNode(1).addLeft(3).addRight(5);
    TreeNode result = new InvertBinaryTree().invertTree(tree);
    assert result.left != null;
    assertThat(result.left.val, is(5));
    assert result.right != null;
    assertThat(result.right.val, is(3));
  }

}