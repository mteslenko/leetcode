package leetcode.tasks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class WaterAndJugProblemTest {
  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[]{21, 5, 8, true},
        new Object[]{5, 3, 4, true},
        new Object[]{7, 3, 5, true},
        new Object[]{2, 6, 5, false});
  }

  @SuppressWarnings("WeakerAccess")
  @Parameter
  public int x;

  @SuppressWarnings("WeakerAccess")
  @Parameter(1)
  public int y;

  @SuppressWarnings("WeakerAccess")
  @Parameter(2)
  public int z;

  @SuppressWarnings("WeakerAccess")
  @Parameter(3)
  public boolean expected;


  @Test
  public void ladderLength() {
    boolean result = new WaterAndJugProblem().canMeasureWater(x, y, z);
    assertThat(result, is(expected));
  }

}