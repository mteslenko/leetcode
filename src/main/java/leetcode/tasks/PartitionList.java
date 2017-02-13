package leetcode.tasks;

/**
 * @see <a href="https://leetcode.com/problems/partition-list/">Leetcode</a>
 */
public class PartitionList {
  public ListNode partition(ListNode head, int x) {
    if (head == null) {
      return null;
    }
    ListNode lp = new ListNode(0);
    ListNode rp = new ListNode(0);
    ListNode l = lp;
    ListNode r = rp;
    while (head != null) {
      if (head.val < x) {
        lp.next = new ListNode(head.val);
        lp = lp.next;
      } else {
        rp.next = new ListNode(head.val);
        rp = rp.next;
      }
      head = head.next;
    }
    lp.next = r.next;
    return l.next;

  }
}
