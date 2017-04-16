package leetcode.tasks;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class FindLargestValueInEachTreeRowTest {
  @Test
  public void largestValues() {
    List<Integer> result =
        new FindLargestValueInEachTreeRow().largestValues(TreeNode.buildTree(new Integer[]{
            1,
            3,
            2,
            5,
            3,
            null,
            9}));
    assertThat(result, is(Arrays.asList(1, 3, 9)));
  }

}