package leetcode.tasks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class ReverseWordsInAStringTest {
  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[]{"the sky is blue", "blue is sky the"},
        new Object[]{" 1", "1"},
        new Object[]{"1 ", "1"},
        new Object[]{" ", ""},
        new Object[]{"sky", "sky"});
  }

  @SuppressWarnings("WeakerAccess")
  @Parameterized.Parameter
  public String input;

  @SuppressWarnings("WeakerAccess")
  @Parameterized.Parameter(1)
  public String expected;

  @Test
  public void reverseWords() throws Exception {
    String result = new ReverseWordsInAString().reverseWords(input);
    assertThat(result, is(expected));
  }

}