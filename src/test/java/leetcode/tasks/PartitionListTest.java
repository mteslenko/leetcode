package leetcode.tasks;

import leetcode.utils.ListNodeUtils;
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
public class PartitionListTest {

  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[]{null, 3, null}, new Object[]{
        ListNodeUtils.createListNode(1, 4, 3, 2, 5, 2),
        3,
        ListNodeUtils.createListNode(1, 2, 2, 4, 3, 5)});
  }

  @SuppressWarnings("WeakerAccess")
  @Parameter
  public ListNode input;

  @SuppressWarnings("WeakerAccess")
  @Parameter(1)
  public int x;

  @SuppressWarnings("WeakerAccess")
  @Parameter(2)
  public ListNode expected;

  @Test
  public void partition() {
    assertThat(
        ListNodeUtils.toList(new PartitionList().partition(input, x)),
        is(ListNodeUtils.toList(expected)));
  }
}