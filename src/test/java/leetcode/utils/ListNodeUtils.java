package leetcode.utils;

import leetcode.tasks.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ListNodeUtils {
  public static ListNode createListNode(int... nodes) {
    ListNode head = new ListNode(0);
    ListNode p = head;
    for (int node : nodes) {
      p.next = new ListNode(node);
      p = p.next;
    }
    return head.next;
  }

  public static boolean equals(ListNode l1, ListNode l2) {
    if (l1 == null || l2 == null) {
      return l1 == l2;
    }
    while(l1.val == l2.val) {
      if(l1.next == null || l2.next == null) {
        return l1.next == l2.next;
      }
      l1 = l1.next;
      l2 = l2.next;
    }
    return false;
  }

  public static List<Integer> toList(ListNode list) {
    if(list == null) {
      return new ArrayList<>();
    }
    List<Integer> l = new ArrayList<>();
    l.add(list.val);
    while(list.next != null) {
      list = list.next;
      l.add(list.val);
    }
    return l;
  }
}
