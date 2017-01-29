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
public class LongestIncreasingSubsequenceTest {
  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[]{new int[]{4, 10, 4, 3, 8, 9}, 3},
        new Object[]{new int[]{10, 9, 2, 5, 3, 7, 101, 18}, 4},
        new Object[]{new int[]{2, 2}, 1},
        new Object[]{new int[]{2, 6, 5}, 2});
  }

  @SuppressWarnings("WeakerAccess")
  @Parameter
  public int[] nums;

  @SuppressWarnings("WeakerAccess")
  @Parameter(1)
  public int expected;


  @Test
  public void lengthOfLIS() {
    int result = new LongestIncreasingSubsequence().lengthOfLIS(nums);
    assertThat(result, is(expected));
  }

  @Test
  public void lengthOfLIS_DP() {
    int result = new LongestIncreasingSubsequence().lengthOfLIS_DP(nums);
    assertThat(result, is(expected));
  }

}