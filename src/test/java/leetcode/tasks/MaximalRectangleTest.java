package leetcode.tasks;


import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MaximalRectangleTest {
  @Test
  public void maximalRectangle() {
    int result = new MaximalRectangle().maximalRectangle(new char[][]{
        new char[]{'1', '0', '1', '0', '0'},
        new char[]{'1', '0', '1', '1', '1'},
        new char[]{'1', '1', '1', '1', '1'}});
    assertThat(result, is(6));
  }


  @Test
  public void maximalRectangle_1() {
    int result = new MaximalRectangle().maximalRectangle(new char[][]{
        "10100".toCharArray(),
        "10111".toCharArray(),
        "11111".toCharArray(),
        "10010".toCharArray()});
    assertThat(result, is(6));
  }

  @Test
  public void maximalRectangle_2() {
    int result = new MaximalRectangle().maximalRectangle(new char[][]{
        "1101".toCharArray(), "1101".toCharArray(), "1111".toCharArray()});
    assertThat(result, is(6));
  }
}