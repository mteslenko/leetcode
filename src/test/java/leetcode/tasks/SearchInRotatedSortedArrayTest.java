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
public class SearchInRotatedSortedArrayTest {
  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[]{new int[]{1, 3}, 3, 1},
        new Object[]{
            new int[]{
                4, 5, 6, 7, 0, 1, 2}, 1, 5},
        new Object[]{
            new int[]{
                4, 5, 6, 7, 0, 1, 2}, 0, 4},
        new Object[]{new int[]{4, 5, 6, 7, 0, 1, 2}, 8, -1},
        new Object[]{new int[]{21, 5, 8}, 8, 2},
        new Object[]{new int[]{5, 3, 4}, 2, -1});
  }

  @SuppressWarnings("WeakerAccess")
  @Parameter
  public int[] nums;

  @SuppressWarnings("WeakerAccess")
  @Parameter(1)
  public int target;

  @SuppressWarnings("WeakerAccess")
  @Parameter(2)
  public int expected;


  @Test
  public void ladderLength() {
    int result = new SearchInRotatedSortedArray().search(nums, target);
    assertThat(result, is(expected));
  }

}