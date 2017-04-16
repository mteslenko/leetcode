package leetcode.tasks;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class FindBottomLeftTreeValueTest {
  @Test
  public void findBottomLeftValue() {
    int result =
        new FindBottomLeftTreeValue().findBottomLeftValue(TreeNode.buildTree(new Integer[]{
            2,
            1,
            3}));
    assertThat(result, is(1));
  }

  @Test
  public void findBottomLeftValue_1() {
    int result =
        new FindBottomLeftTreeValue().findBottomLeftValue(TreeNode.buildTree(new Integer[]{
            2,
            1,
            3,
            null,
            0}));
    assertThat(result, is(0));
  }

}