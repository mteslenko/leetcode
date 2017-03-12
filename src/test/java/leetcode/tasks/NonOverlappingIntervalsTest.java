package leetcode.tasks;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class NonOverlappingIntervalsTest {
  @Test
  public void eraseOverlapIntervals() {
    int result = new NonOverlappingIntervals().eraseOverlapIntervals(new Interval[]{
        new Interval(1, 2), new Interval(2, 3), new Interval(1, 3)});
    assertThat(result, is(1));
  }

  @Test
  public void eraseOverlapIntervals_1() {
    int result = new NonOverlappingIntervals().eraseOverlapIntervals(new Interval[]{
        new Interval(1, 2), new Interval(1, 2), new Interval(1, 2)});
    assertThat(result, is(2));
  }

  @Test
  public void eraseOverlapIntervals_2() {
    int result = new NonOverlappingIntervals().eraseOverlapIntervals(new Interval[]{
        new Interval(1, 100), new Interval(11, 22), new Interval(1, 11), new Interval(2, 12)});
    assertThat(result, is(2));
  }

  @Test
  public void eraseOverlapIntervals_3() {
    int result = new NonOverlappingIntervals().eraseOverlapIntervals(new Interval[]{
        new Interval(0, 2),
        new Interval(1, 3),
        new Interval(2, 4),
        new Interval(3, 5),
        new Interval(4, 6)});
    assertThat(result, is(2));
  }

  @Test
  public void eraseOverlapIntervals_dp() {
    int result = new NonOverlappingIntervals().eraseOverlapIntervals_dp(new Interval[]{
        new Interval(1, 2), new Interval(2, 3), new Interval(1, 3)});
    assertThat(result, is(1));
  }

  @Test
  public void eraseOverlapIntervals_dp_1() {
    int result = new NonOverlappingIntervals().eraseOverlapIntervals_dp(new Interval[]{
        new Interval(1, 2), new Interval(1, 2), new Interval(1, 2)});
    assertThat(result, is(2));
  }

  @Test
  public void eraseOverlapIntervals_bruteForce() {
    int result = new NonOverlappingIntervals().eraseOverlapIntervals_bruteForce(new Interval[]{
        new Interval(1, 2), new Interval(2, 3), new Interval(1, 3)});
    assertThat(result, is(1));
  }

  @Test
  public void eraseOverlapIntervals_bruteForce_1() {
    int result = new NonOverlappingIntervals().eraseOverlapIntervals_bruteForce(new Interval[]{
        new Interval(1, 2), new Interval(1, 2), new Interval(1, 2)});
    assertThat(result, is(2));
  }

}