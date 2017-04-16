package leetcode.tasks;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.*;

public class RemoveInvalidParenthesesTest {
  @Test
  public void removeInvalidParentheses() {
    List<String> results = new RemoveInvalidParentheses().removeInvalidParentheses("()())()");
    assertThat(results, containsInAnyOrder("()()()", "(())()"));
  }

  @Test
  public void removeInvalidParentheses_1() {
    List<String> results = new RemoveInvalidParentheses().removeInvalidParentheses(")d))");
    assertThat(results, containsInAnyOrder("d"));
  }

}