package leetcode.tasks;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.*;

public class FactorCombinationsTest {
  @Test
  public void getFactors() {
    List<List<Integer>> factors = new FactorCombinations().getFactors(12);
    Object[] expected = {Arrays.asList(2, 2, 3), Arrays.asList(2, 6), Arrays.asList(3, 4)};
    assertThat(
        factors,
        containsInAnyOrder(expected));
  }

  @Test
  public void getFactors_1() {
    List<List<Integer>> factors = new FactorCombinations().getFactors(15);
    Object[] expected = {Arrays.asList(3, 5)};
    assertThat(
        factors,
        containsInAnyOrder(expected));
  }

}