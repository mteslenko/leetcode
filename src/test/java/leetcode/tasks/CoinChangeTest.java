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
public class CoinChangeTest {
  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[]{new int[]{186, 419, 83, 408}, 6249, 20},
        new Object[]{new int[]{1, 2, 5}, 11, 3},
        new Object[]{new int[]{1, 2}, 7, 4},
        new Object[]{new int[]{2, 4}, 7, -1});
  }

  @SuppressWarnings("WeakerAccess")
  @Parameter
  public int[] candidates;

  @SuppressWarnings("WeakerAccess")
  @Parameter(1)
  public int target;

  @SuppressWarnings("WeakerAccess")
  @Parameter(2)
  public int expected;


  @Test
  public void combinationSum() {
    int result = new CoinChange().coinChange(candidates, target);
    assertThat(result, is(expected));
  }

}