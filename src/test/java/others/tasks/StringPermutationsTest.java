package others.tasks;

import leetcode.tasks.Permutations;
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
public class StringPermutationsTest {
  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[]{
        "12", Arrays.asList("12", "21")}, new Object[]{
        "123", Arrays.asList("123", "132", "213", "231", "312", "321")});
  }

  @SuppressWarnings("WeakerAccess")
  @Parameter
  public String str;

  @SuppressWarnings("WeakerAccess")
  @Parameter(1)
  public List<String> expected;


  @Test
  public void maxSubArray() {
    List<String> result = new StringPermutations().permutation(str);
    assertThat(result, is(expected));
  }

}