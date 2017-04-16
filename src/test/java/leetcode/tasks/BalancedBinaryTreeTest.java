package leetcode.tasks;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class BalancedBinaryTreeTest {
  @Test
  public void isBalanced() {
    boolean balanced =
        new BalancedBinaryTree().isBalanced(TreeNode.buildTree(new Integer[]{5, 2, null, 1}));
    assertThat(balanced, is(false));
  }

}