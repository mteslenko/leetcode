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
public class NQueensTest {
  @Parameters
  public static Collection<Object[]> data() {
    return Collections.singletonList(new Object[]{
        4, Arrays.asList(
        Arrays.asList(".Q..", "...Q", "Q...", "..Q."),
        Arrays.asList("..Q.", "Q...", "...Q", ".Q.."))});
  }

  @SuppressWarnings("WeakerAccess")
  @Parameter
  public int n;

  @SuppressWarnings("WeakerAccess")
  @Parameter(1)
  public List<List<String>> expected;

  @Test
  public void solveNQueens() {
    List<List<String>> result = new NQueens().solveNQueens(n);
    assertThat(result, is(expected));
  }

}