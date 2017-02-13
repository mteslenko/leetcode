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
public class UniquePaths2Test {
  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[]{new int[][]{new int[]{0}, new int[]{1}}, 0},
        new Object[]{new int[][]{new int[]{0, 0}, new int[]{0, 0}}, 2},
        new Object[]{new int[][]{new int[]{0, 0, 0}, new int[]{0, 1, 0}, new int[]{0, 0, 0}}, 2});
  }

  @SuppressWarnings("WeakerAccess")
  @Parameter
  public int[][] grid;

  @SuppressWarnings("WeakerAccess")
  @Parameter(1)
  public int expected;


  @Test
  public void uniquePathsWithObstacles() {
    int result = new UniquePaths2().uniquePathsWithObstacles(grid);
    assertThat(result, is(expected));
  }

}