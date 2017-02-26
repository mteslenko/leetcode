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
public class GenerateParenthesesTest {
  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[]{2, Arrays.asList("(())", "()()")},
        new Object[]{3, Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()")});
  }

  @SuppressWarnings("WeakerAccess")
  @Parameter
  public int n;

  @SuppressWarnings("WeakerAccess")
  @Parameter(1)
  public List<String> expected;


  @Test
  public void generateParenthesis() {
    List<String> result = new GenerateParentheses().generateParenthesis(n);
    assertThat(result, is(expected));
  }

}