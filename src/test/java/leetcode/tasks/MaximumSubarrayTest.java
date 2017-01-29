package leetcode.tasks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class MaximumSubarrayTest {
  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[]{new int[]{-2, -1}, -1},
        new Object[]{new int[]{3, -1, 6}, 8},
        new Object[]{new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}, 6});
  }

  @SuppressWarnings("WeakerAccess")
  @Parameter
  public int[] nums;

  @SuppressWarnings("WeakerAccess")
  @Parameter(1)
  public int expected;


  @Test
  public void maxSubArray() {
    int result = new MaximumSubarray().maxSubArray(nums);
    assertThat(result, is(expected));
  }

}