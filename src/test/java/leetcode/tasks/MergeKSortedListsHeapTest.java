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
public class MergeKSortedListsHeapTest {

  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[]{null, null},
        new Object[]{new ListNode[0], null},
        new Object[]{new ListNode[]{null}, null},
        new Object[]{new ListNode[]{null, null}, null},
        new Object[]{
            new ListNode[]{new ListNode(1)}, new ListNode(1)
        },
        new Object[]{
            new ListNode[]{new ListNode(1), new ListNode(2)}, ListNodeUtils.createListNode(1, 2)
        },
        new Object[]{
            new ListNode[]{new ListNode(2), null, new ListNode(-1)},
            ListNodeUtils.createListNode(-1, 2)
        },
        new Object[]{
            new ListNode[]{
                ListNodeUtils.createListNode(1, 3), ListNodeUtils.createListNode(2)
            }, ListNodeUtils.createListNode(1, 2, 3)
        },
        new Object[]{
            new ListNode[]{
                ListNodeUtils.createListNode(1, 3), ListNodeUtils.createListNode(2, 4)
            }, ListNodeUtils.createListNode(1, 2, 3, 4)
        });
  }

  @SuppressWarnings("WeakerAccess")
  @Parameter
  public ListNode[] input;

  @SuppressWarnings("WeakerAccess")
  @Parameter(1)
  public ListNode expected;

  @Test
  public void mergeKLists() {
    ListNode result = new MergeKSortedListsHeap().mergeKLists(input);
    assertThat(ListNodeUtils.toList(result), is(ListNodeUtils.toList(expected)));
  }

}