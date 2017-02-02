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
public class ContainerWithMostWaterTest {
  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[]{new int[]{1, 2, 4, 3}, 4},
        new Object[]{new int[]{3, 5, 8}, 6},
        new Object[]{new int[]{1, 1}, 1},
        new Object[]{new int[]{1, 2, 2}, 2});
  }

  @SuppressWarnings("WeakerAccess")
  @Parameter
  public int[] candidates;

  @SuppressWarnings("WeakerAccess")
  @Parameter(1)
  public int expected;


  @Test
  public void maxArea() {
    int result = new ContainerWithMostWater().maxArea(candidates);
    assertThat(result, is(expected));
  }

}