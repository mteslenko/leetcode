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
public class WordSearchTest {
  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[]{
        new char[][]{
            new char[]{'C', 'A', 'A'}, new char[]{'A', 'A', 'A'}, new char[]{'B', 'C', 'D'}},
        "AAB",
        true}, new Object[]{
        new char[][]{
            new char[]{'a', 'a'}}, "aa", true}, new Object[]{
        new char[][]{
            new char[]{'A', 'B', 'C', 'E'},
            new char[]{'S', 'F', 'C', 'S'},
            new char[]{'A', 'D', 'E', 'E'}}, "ABCCED", true}, new Object[]{
        new char[][]{
            new char[]{'A', 'B', 'C', 'E'},
            new char[]{'S', 'F', 'C', 'S'},
            new char[]{'A', 'D', 'E', 'E'}}, "SEE", true}, new Object[]{
        new char[][]{
            new char[]{'A', 'B', 'C', 'E'},
            new char[]{'S', 'F', 'C', 'S'},
            new char[]{'A', 'D', 'E', 'E'}}, "ABCB", false});
  }

  @SuppressWarnings("WeakerAccess")
  @Parameter
  public char[][] board;

  @SuppressWarnings("WeakerAccess")
  @Parameter(1)
  public String target;

  @SuppressWarnings("WeakerAccess")
  @Parameter(2)
  public boolean expected;


  @Test
  public void exist() {
    boolean result = new WordSearch().exist(board, target);
    assertThat(result, is(expected));
  }

}