package others.tasks;

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
public class MinimumStepsToOneTest {
  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[]{3852, 12},
        new Object[]{1401, 12},
        new Object[]{401, 10},
        new Object[]{329, 8},
        new Object[]{100, 7},
        new Object[]{1, 0},
        new Object[]{4, 2},
        new Object[]{7, 3},
        new Object[]{10, 3});
  }

  @SuppressWarnings("WeakerAccess")
  @Parameter
  public int num;

  @SuppressWarnings("WeakerAccess")
  @Parameter(1)
  public int expected;


  @Test
  public void recursion() {
    int result = new MinimumStepsToOne().doRecursion(num);
    assertThat(result, is(expected));
  }

  @Test
  public void memoization() {
    int result = new MinimumStepsToOne().doMemoization(num);
    assertThat(result, is(expected));
  }

  @Test
  public void bottomUp() {
    int result = new MinimumStepsToOne().doBottomUp(num);
    assertThat(result, is(expected));
  }

}