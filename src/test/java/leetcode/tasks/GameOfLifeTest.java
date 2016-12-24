package leetcode.tasks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class GameOfLifeTest {
  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[]{
            new int[][]{{0, 0, 0, 0}, {0, 1, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}},
            new int[][]{{0, 0, 0, 0}, {0, 1, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}}
        },
        new Object[]{new int[][]{{1, 0}, {0, 0}}, new int[][]{{0, 0}, {0, 0}}},
        new Object[]{new int[][]{{1, 0, 0}, {0, 0, 0}}, new int[][]{{0, 0, 0}, {0, 0, 0}}},
        new Object[]{new int[][]{{1, 1}, {1, 0}}, new int[][]{{1, 1}, {1, 1}}});
  }

  @SuppressWarnings("WeakerAccess")
  @Parameterized.Parameter
  public int[][] board;

  @SuppressWarnings("WeakerAccess")
  @Parameterized.Parameter(1)
  public int[][] expected;

  @Test
  public void gameOfLife() throws Exception {
    new GameOfLife().gameOfLife(board);
    assertThat(board, is(expected));
  }

}