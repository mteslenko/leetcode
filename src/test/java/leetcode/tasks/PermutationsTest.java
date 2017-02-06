package leetcode.tasks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class PermutationsTest {
  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[]{
        new int[]{1, 2}, Arrays.asList(Arrays.asList(1, 2), Arrays.asList(2, 1))}, new Object[]{
        new int[]{1, 2, 3}, Arrays.asList(
        Arrays.asList(1, 2, 3),
        Arrays.asList(1, 3, 2),
        Arrays.asList(2, 1, 3),
        Arrays.asList(2, 3, 1),
        Arrays.asList(3, 1, 2),
        Arrays.asList(3, 2, 1))});
  }

  @SuppressWarnings("WeakerAccess")
  @Parameter
  public int[] nums;

  @SuppressWarnings("WeakerAccess")
  @Parameter(1)
  public List<List<Integer>> expected;


  @Test
  public void maxSubArray() {
    List<List<Integer>> result = new Permutations().permute(nums);
    assertThat(result, is(expected));
  }

}