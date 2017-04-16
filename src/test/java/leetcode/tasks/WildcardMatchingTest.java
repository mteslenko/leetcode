package leetcode.tasks;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class WildcardMatchingTest {
  @Test
  public void isMatch() {
    boolean result = new WildcardMatching().isMatch("aa", "a?");
    assertThat(result, is(true));
  }

  @Test
  public void isMatch_1() {
    boolean result = new WildcardMatching().isMatch("aa", "a*");
    assertThat(result, is(true));
  }

  @Test
  public void isMatch_2() {
    boolean result = new WildcardMatching().isMatch("aaa", "ab*");
    assertThat(result, is(false));
  }

  @Test
  public void isMatch_3() {
    boolean result = new WildcardMatching().isMatch("aaba", "aab*a");
    assertThat(result, is(true));
  }

  @Test
  public void isMatch_4() {
    boolean result = new WildcardMatching().isMatch("a", "a*");
    assertThat(result, is(true));
  }

  @Test
  public void isMatch_5() {
    boolean result = new WildcardMatching().isMatch("aaa", "ab*ac*a");
    assertThat(result, is(false));
  }

  @Test
  public void isMatch_6() {
    boolean result = new WildcardMatching().isMatch("aaa", "?*");
    assertThat(result, is(true));
  }

  @Test
  public void isMatch_7() {
    boolean result = new WildcardMatching().isMatch("aa", "*");
    assertThat(result, is(true));
  }

  @Test
  public void isMatch_8() {
    boolean result = new WildcardMatching().isMatch("abcdef", "a*f");
    assertThat(result, is(true));
  }

  @Test
  public void isMatch_9() {
    boolean result = new WildcardMatching().isMatch("aab", "c*a*b");
    assertThat(result, is(false));
  }

  @Test
  public void isMatch_10() {
    boolean result = new WildcardMatching().isMatch("c", "*?*");
    assertThat(result, is(true));
  }

  @Test
  public void isMatch_11() {
    boolean result = new WildcardMatching().isMatch("ho", "**ho");
    assertThat(result, is(true));
  }

  @Test
  public void isMatch_12() {
    boolean result = new WildcardMatching().isMatch(
        "mississ",
        "m*si*");
    assertThat(result, is(true));
  }

}