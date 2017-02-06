package leetcode.tasks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class BestTimeToBuyAndSellStock4Test {
  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[]{new int[]{7, 1, 5, 3, 6, 4}, 2, 7},
        new Object[]{new int[]{1, 3}, 2, 2});
  }

  @SuppressWarnings("WeakerAccess")
  @Parameter
  public int[] prices;

  @SuppressWarnings("WeakerAccess")
  @Parameter(1)
  public int k;

  @SuppressWarnings("WeakerAccess")
  @Parameter(2)
  public int expected;


  @Test
  public void maxProfit() {
    int result = new BestTimeToBuyAndSellStock4().maxProfit(k, prices);
    assertThat(result, is(expected));
  }

}