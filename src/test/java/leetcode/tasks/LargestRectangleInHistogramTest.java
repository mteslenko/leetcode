package leetcode.tasks;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LargestRectangleInHistogramTest {
  @Test
  public void largestRectangleArea() {
    int rectangleArea =
        new LargestRectangleInHistogram().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
    assertThat(rectangleArea, is(10));
  }

  @Test
  public void largestRectangleArea_0() {
    int rectangleArea = new LargestRectangleInHistogram().largestRectangleArea(new int[]{0});
    assertThat(rectangleArea, is(0));
  }

  @Test
  public void largestRectangleArea_1() {
    int rectangleArea = new LargestRectangleInHistogram().largestRectangleArea(new int[]{2, 4});
    assertThat(rectangleArea, is(4));
  }

  @Test
  public void largestRectangleArea_2() {
    int rectangleArea = new LargestRectangleInHistogram().largestRectangleArea(new int[]{0, 9});
    assertThat(rectangleArea, is(9));
  }

  @Test
  public void largestRectangleArea_3() {
    int rectangleArea = new LargestRectangleInHistogram().largestRectangleArea(new int[]{2, 1, 2});
    assertThat(rectangleArea, is(3));
  }

  @Test
  public void largestRectangleArea_4() {
    int rectangleArea =
        new LargestRectangleInHistogram().largestRectangleArea(new int[]{5, 4, 1, 2});
    assertThat(rectangleArea, is(8));
  }

  @Test
  public void largestRectangleArea_5() {
    int rectangleArea =
        new LargestRectangleInHistogram().largestRectangleArea(new int[]{4, 2, 0, 3, 2, 5});
    assertThat(rectangleArea, is(6));
  }

  @Test
  public void largestRectangleArea_6() {
    int rectangleArea =
        new LargestRectangleInHistogram().largestRectangleArea(new int[]{2, 1, 2, 3, 1});
    assertThat(rectangleArea, is(5));
  }

}