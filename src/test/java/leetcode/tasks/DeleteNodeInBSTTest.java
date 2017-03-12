package leetcode.tasks;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DeleteNodeInBSTTest {
  @Test
  public void deleteNode() {
    TreeNode result =
        new DeleteNodeInBST().deleteNode(
            TreeNode.buildTree(new Integer[]{5, 3, 6, 2, 4, null, 7}),
            3);
    assert result.left != null;
    assertThat(result.left.val, is(4));
  }

}