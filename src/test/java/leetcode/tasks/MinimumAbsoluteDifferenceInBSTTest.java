package leetcode.tasks;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class MinimumAbsoluteDifferenceInBSTTest {
  @Test
  public void getMinimumDifference() {
    TreeNode tree = TreeNode.buildTree(new Integer[]{0, null, 2236, 1277, 2776, 519});
    assertThat(new MinimumAbsoluteDifferenceInBST().getMinimumDifference(tree), is(519));
  }

}