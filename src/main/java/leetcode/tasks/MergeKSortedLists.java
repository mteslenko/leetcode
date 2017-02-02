package leetcode.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 *
 * @see <a href="https://leetcode.com/problems/merge-k-sorted-lists/">Leetcode</a>
 */
class MergeKSortedLists {
  ListNode mergeKLists_heap(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }
    Queue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
    Arrays.stream(lists).filter(list -> !Objects.isNull(list)).forEach(heap::add);
    ListNode head = new ListNode(0);
    ListNode p = head;
    while (heap.peek() != null) {
      ListNode list = heap.poll();
      p.next = list;
      p = p.next;
      if (list.next != null) {
        heap.offer(list.next);
      }
    }
    return head.next;
  }


  ListNode mergeKLists_divide(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }
    while (lists.length > 1) {
      List<ListNode> mergedLists = new ArrayList<>(lists.length / 2 + 1);
      for (int i = 0; i < lists.length; i += 2) {
        ListNode list1 = lists[i];
        ListNode list2 = i + 1 < lists.length ? lists[i + 1] : null;
        ListNode mergedList = merge2Lists(list1, list2);
        if (mergedList != null) {
          mergedLists.add(mergedList);
        }
      }
      lists = mergedLists.toArray(new ListNode[mergedLists.size()]);

    }
    return lists.length == 0 ? null : lists[0];
  }

  private static ListNode merge2Lists(ListNode list1, ListNode list2) {
    ListNode result = new ListNode(0);
    ListNode p = result;
    while (list1 != null || list2 != null) {
      if (list1 != null) {
        if (list2 == null || list1.val < list2.val) {
          p.next = list1;
          list1 = list1.next;
        } else {
          p.next = list2;
          list2 = list2.next;
        }
      } else {
        p.next = list2;
        list2 = list2.next;
      }
      p = p.next;
    }
    return result.next;
  }
}
