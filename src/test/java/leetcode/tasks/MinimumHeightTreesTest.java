package leetcode.tasks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MinimumHeightTreesTest {
  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[]{1, new int[0][0], Collections.singletonList(0)},
        new Object[]{4, new int[][]{{1, 0}, {1, 2}, {1, 3}}, Collections.singletonList(1)},
        new Object[]{6, new int[][]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}}, Arrays.asList(3, 4)});
  }

  @SuppressWarnings("WeakerAccess")
  @Parameterized.Parameter
  public int n;

  @SuppressWarnings("WeakerAccess")
  @Parameterized.Parameter(1)
  public int[][] edges;

  @SuppressWarnings("WeakerAccess")
  @Parameterized.Parameter(2)
  public List<Integer> expected;

  @Test
  public void findMinHeightTrees() throws Exception {
    List<Integer> result = new MinimumHeightTrees().findMinHeightTrees(n, edges);
    assertThat(result, is(expected));
  }
}