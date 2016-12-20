package leetcode.tasks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ImplementStrStrTest {
  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[]{"", "", 0}, new Object[] {"abxabc", "abc", 3});
  }

  @SuppressWarnings("WeakerAccess")
  @Parameterized.Parameter
  public String haystack;

  @SuppressWarnings("WeakerAccess")
  @Parameterized.Parameter(1)
  public String needle;

  @SuppressWarnings("WeakerAccess")
  @Parameterized.Parameter(2)
  public int expected;


  @Test
  public void strStr() throws Exception {
    int result = new ImplementStrStr().strStr(haystack, needle);
    assertThat(result, is(expected));
  }

}