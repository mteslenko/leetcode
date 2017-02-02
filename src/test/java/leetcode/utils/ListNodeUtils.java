package leetcode.utils;

import leetcode.tasks.ListNode;

import java.util.ArrayList;
import java.util.List;

public final class ListNodeUtils {
  private ListNodeUtils() {
  }

  public static ListNode createListNode(int... nodes) {
    ListNode head = new ListNode(0);
    ListNode p = head;
    for (int node : nodes) {
      p.next = new ListNode(node);
      p = p.next;
    }
    return head.next;
  }

  public static List<Integer> toList(ListNode list) {
    if (list == null) {
      return new ArrayList<>();
    }
    List<Integer> l = new ArrayList<>();
    l.add(list.val);
    while (list.next != null) {
      list = list.next;
      l.add(list.val);
    }
    return l;
  }

  public static ListNode[] makeCopy(ListNode[] lists) {
    if (lists == null) {
      return null;
    } else {
      ListNode[] copy = new ListNode[lists.length];
      for (int i = 0; i < lists.length; i++) {
        ListNode node = lists[i];
        copy[i] = makeCopy(node);
      }
      return copy;
    }
  }


  public static ListNode makeCopy(ListNode list) {
    ListNode head = new ListNode(0);
    ListNode p = head;
    while (list != null) {
      p.next = new ListNode(list.val);
      p = p.next;
      list = list.next;
    }
    return head.next;
  }
}
