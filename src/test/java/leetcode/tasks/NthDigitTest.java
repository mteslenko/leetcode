package leetcode.tasks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class NthDigitTest {
  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[]{10, 1}, new Object[]{11, 0}, new Object[]{3, 3});
  }

  @SuppressWarnings("WeakerAccess")
  @Parameterized.Parameter
  public int n;

  @SuppressWarnings("WeakerAccess")
  @Parameterized.Parameter(1)
  public int expected;

  @Test
  public void findNthDigit() throws Exception {
    int result = new NthDigit().findNthDigit(n);
    assertThat(result, is(expected));
  }

}