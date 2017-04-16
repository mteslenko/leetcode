package leetcode.tasks;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class LongestSubstringWithoutRepeatingCharactersTest {
  @Test
  public void lengthOfLongestSubstring() {
    int result =
        new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("tmmzuxt");
    assertThat(result, is(5));
  }

}