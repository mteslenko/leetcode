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
public class Permutations2Test {
  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[]{
            new int[]{1, 1, 1, 1, 1, 1, 1},
            Collections.singletonList(Arrays.asList(1, 1, 1, 1, 1, 1, 1))},
        new Object[]{
            new int[]{1, 2}, Arrays.asList(Arrays.asList(1, 2), Arrays.asList(2, 1))},
        new Object[]{
            new int[]{1, 2, 2},
            Arrays.asList(Arrays.asList(1, 2, 2), Arrays.asList(2, 1, 2), Arrays.asList(2, 2, 1))});
  }

  @SuppressWarnings("WeakerAccess")
  @Parameter
  public int[] nums;

  @SuppressWarnings("WeakerAccess")
  @Parameter(1)
  public List<List<Integer>> expected;


  @Test
  public void permuteUnique() {
    List<List<Integer>> result = new Permutations2().permuteUnique(nums);
    assertThat(result, is(expected));
  }

  @Test
  public void permuteUniqueNotOptimized() {
    List<List<Integer>> result = new Permutations2().permuteUniqueNotOptimized(nums);
    assertThat(result, is(expected));
  }

}