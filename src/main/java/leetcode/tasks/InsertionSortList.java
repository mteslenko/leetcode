package leetcode.tasks;

/**
 * Sort a linked list using insertion sort.
 *
 * @see <a href="https://leetcode.com/problems/insertion-sort-list/">Leetcode</a>
 */
class InsertionSortList {
  ListNode insertionSortList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode newHead = new ListNode(0);
    ListNode current = head;
    while (current != null) {
      ListNode pointer = newHead;
      ListNode next = current.next;
      while (pointer.next != null && pointer.next.val < current.val) {
        pointer = pointer.next;
      }
      current.next = pointer.next;
      pointer.next = current;
      current = next;
    }
    return newHead.next;
  }
}
