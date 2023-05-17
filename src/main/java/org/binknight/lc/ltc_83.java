package org.binknight.lc;

import java.util.HashSet;
import java.util.Set;

public class ltc_83 {
    /**
     * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
     * @param args
     */
    public static void main(String[] args) {
        ListNode header =  new ListNode(-1, new ListNode(0, new ListNode(0,new ListNode(3,new ListNode(3)))));
        ListNode listNode = deleteDuplicates(header);
    }

    public static ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Set<Integer> set = new HashSet<>();
        ListNode temp = new ListNode(-1); // 临时节点，用于记录前一个节点
        temp.next = head;
        ListNode prev = temp;
        ListNode curr = head;
        while (curr != null) {
            if (set.contains(curr.val)) {
                prev.next = curr.next; // 删除重复节点
            } else {
                set.add(curr.val);
                prev = prev.next;
            }
            curr = curr.next;
        }
        return temp.next; // 返回原链表头节点
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = new ListNode(-1); // 临时节点，用于记录前一个节点
        temp.next = head;
        ListNode prev = temp;
        ListNode curr = head;
        while (curr != null) {
            if (prev.val == curr.val) {
                prev.next = curr.next; // 删除重复节点
            } else {
                prev = prev.next;
            }
            curr = curr.next;
        }
        return temp.val== head.val?temp:temp.next;// 返回原链表头节点
    }

    public static ListNode deleteDuplicates2(ListNode head) {
        ListNode temp = new ListNode(-1); // 临时节点，用于记录前一个节点
        while (temp != null) {
            if (temp.next !=null && temp.val == temp.next.val) {
                temp.next = temp.next.next; // 删除重复节点
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

}
