package leetcode.tasks;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class TriangleTest {
  @Test
  public void minimumTotal() {
    int result = new Triangle().minimumTotal(Arrays.asList(
        Collections.singletonList(-1),
        Arrays.asList(2, 3),
        Arrays.asList(1, -1, -3)));
    assertThat(result, is(-1));
  }

}