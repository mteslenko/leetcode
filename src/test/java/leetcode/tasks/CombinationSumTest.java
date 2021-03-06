package leetcode.tasks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class CombinationSumTest {
  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[]{
            new int[]{1, 2}, 3, Arrays.asList(Arrays.asList(1, 1, 1), Arrays.asList(1, 2))},
        new Object[]{
            new int[]{2, 3, 6, 7},
            7,
            Arrays.asList(Arrays.asList(2, 2, 3), Collections.singletonList(7))});
  }

  @SuppressWarnings("WeakerAccess")
  @Parameter
  public int[] candidates;

  @SuppressWarnings("WeakerAccess")
  @Parameter(1)
  public int target;

  @SuppressWarnings("WeakerAccess")
  @Parameter(2)
  public List<List<Integer>> expected;


  @Test
  public void combinationSum() {
    List<List<Integer>> result = new CombinationSum().combinationSum(candidates, target);
    assertThat(result, is(expected));
  }

}