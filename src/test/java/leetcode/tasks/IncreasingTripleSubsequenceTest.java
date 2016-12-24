package leetcode.tasks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class IncreasingTripleSubsequenceTest {
  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[]{new int[]{1, 0, 10, 0, 100}, true},
        new Object[]{new int[]{1, 2, 1, 2, 1}, false},
        new Object[]{new int[]{2, 5, 3, 4, 5}, true},
        new Object[]{new int[]{1, 1, 1, 1, 1}, false},
        new Object[]{new int[]{1, 2, 3, 4, 5}, true},
        new Object[]{new int[]{5, 4, 3, 2, 1}, false});
  }

  @SuppressWarnings("WeakerAccess")
  @Parameterized.Parameter
  public int[] nums;

  @SuppressWarnings("WeakerAccess")
  @Parameterized.Parameter(1)
  public boolean expected;

  @Test
  public void findNthDigit() throws Exception {
    boolean result = new IncreasingTripletSubsequence().increasingTriplet(nums);
    assertThat(result, is(expected));
  }

}