package leetcode.tasks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class SubsetsTest {
  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[]{
            new int[]{1}, Arrays.asList(new ArrayList<Integer>(), Collections.singletonList(1))},
        new Object[]{
            new int[]{1, 2}, Arrays.asList(new ArrayList<Integer>(),
            Collections.singletonList(1),
            Collections.singletonList(2),
            Arrays.asList(1, 2))});
  }

  @SuppressWarnings("WeakerAccess")
  @Parameter
  public int[] nums;

  @SuppressWarnings("WeakerAccess")
  @Parameter(1)
  public List<List<Integer>> expected;


  @Test
  public void subsets() {
    List<List<Integer>> result = new Subsets().subsets(nums);
    assertThat(result, is(expected));
  }

  @Test
  public void subsetsRecursion() {
    List<List<Integer>> result = new Subsets().subsetsRecursion(nums);
    assertThat(result, containsInAnyOrder(expected.toArray()));
  }

}