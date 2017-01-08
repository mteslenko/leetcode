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
public class WordLadderTest {
  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[]{
            "hit",
            "cog",
            new String[]{"hot", "cog", "dot", "dog", "hit", "lot", "log"},
            5},
        new Object[]{"a", "c", new String[]{"a", "b", "c"}, 2},
        new Object[]{"hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}, 5},
        new Object[]{"hit", "hot", new String[]{}, 2}
    );
  }

  @SuppressWarnings("WeakerAccess")
  @Parameter
  public String beginWord;

  @SuppressWarnings("WeakerAccess")
  @Parameter(1)
  public String endWord;

  @SuppressWarnings("WeakerAccess")
  @Parameter(2)
  public String[] wordList;

  @SuppressWarnings("WeakerAccess")
  @Parameter(3)
  public int expected;


  @Test
  public void ladderLength() {
    int result = new WordLadder().ladderLength(
        beginWord, endWord, new HashSet<>(Arrays.asList(wordList)));
    assertThat(result, is(expected));
  }

}