package leetcode.tasks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 *
 * @see <a href="https://leetcode.com/problems/merge-k-sorted-lists/">Leetcode</a>
 */
class MergeKSortedListsHeap {
  static ListNode mergeKLists(ListNode[] lists) {
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
}
