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
public class NQueens2Test {
  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[]{4, 2}, new Object[]{8, 92});
  }

  @SuppressWarnings("WeakerAccess")
  @Parameter
  public int n;

  @SuppressWarnings("WeakerAccess")
  @Parameter(1)
  public int expected;

  @Test
  public void totalNQueens() {
    int result = new NQueens2().totalNQueens(n);
    assertThat(result, is(expected));
  }

}