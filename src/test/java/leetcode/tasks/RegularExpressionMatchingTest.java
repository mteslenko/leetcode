package leetcode.tasks;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class RegularExpressionMatchingTest {
  @Test
  public void isMatch() {
    boolean result = new RegularExpressionMatching().isMatch("aa", "a.");
    assertThat(result, is(true));
  }

  @Test
  public void isMatch_1() {
    boolean result = new RegularExpressionMatching().isMatch("aa", "a*");
    assertThat(result, is(true));
  }

  @Test
  public void isMatch_2() {
    boolean result = new RegularExpressionMatching().isMatch("aaa", "ab*");
    assertThat(result, is(false));
  }

  @Test
  public void isMatch_3() {
    boolean result = new RegularExpressionMatching().isMatch("aaba", "aab*a");
    assertThat(result, is(true));
  }

  @Test
  public void isMatch_4() {
    boolean result = new RegularExpressionMatching().isMatch("a", "a*");
    assertThat(result, is(true));
  }

  @Test
  public void isMatch_5() {
    boolean result = new RegularExpressionMatching().isMatch("aaa", "ab*ac*a");
    assertThat(result, is(true));
  }

  @Test
  public void isMatch_6() {
    boolean result = new RegularExpressionMatching().isMatch("aaa", ".*");
    assertThat(result, is(true));
  }

}