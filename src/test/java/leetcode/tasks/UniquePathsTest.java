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
public class UniquePathsTest {
  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[]{1, 2, 1},
        new Object[]{2, 2, 2});
  }

  @SuppressWarnings("WeakerAccess")
  @Parameter
  public int m;

  @SuppressWarnings("WeakerAccess")
  @Parameter(1)
  public int n;

  @SuppressWarnings("WeakerAccess")
  @Parameter(2)
  public int expected;


  @Test
  public void topDown() {
    int result = new UniquePaths().topDown(m, n);
    assertThat(result, is(expected));
  }

  @Test
  public void bottomUp() {
    int result = new UniquePaths().bottomUp(m, n);
    assertThat(result, is(expected));
  }

}