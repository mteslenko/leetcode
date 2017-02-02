package leetcode.tasks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class UniqueBinarySearchTreesTest {
  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[]{1, 1},
        new Object[]{2, 2},
        new Object[]{3, 5},
        new Object[]{4, 14},
        new Object[]{5, 42}
        );
  }

  @SuppressWarnings("WeakerAccess")
  @Parameter
  public Integer input;

  @SuppressWarnings("WeakerAccess")
  @Parameter(1)
  public Integer expected;

  @Test
  public void numTrees() {
    assertThat(new UniqueBinarySearchTrees().numTrees_bottomUp(input), is(expected));
    assertThat(new UniqueBinarySearchTrees().numTrees_topDown(input), is(expected));
  }

}