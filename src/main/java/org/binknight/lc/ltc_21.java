package org.binknight.lc;

import java.math.BigInteger;
import java.util.Map;
import java.util.TreeMap;

public class ltc_21 {
    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * 1 -> 2 -> 4
     * 1 -> 3 -> 4
     */
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode listNode = mergeTwoLists(list1, list2);
        ListNode c = listNode;
        while (c !=null){
            System.out.print(c.val + " ");
            c = c.next;
        }
        int[] cc = {1,2,3};
        plusOne(cc);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        if (l1 != null) {
            cur.next = l1;
        }

        if (l2 != null) {
            cur.next = l2;
        }

        return dummy.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode res = l1.val < l2.val ? l1 : l2;
        res.next = mergeTwoLists(res.next, l1.val >= l2.val ? l1 : l2);
        return res;
    }

    public static int[] plusOne(int[] digits) {
        String n = "";
        for(int i=0; i< digits.length;i++){
            n +=digits[i];
        }
        char[] c = new BigInteger(n).add(new BigInteger("1")).toString().toCharArray();
        int[] a = new int[c.length];
        for(int k=0; k< c.length;k++){
            a[k] = Integer.parseInt(c[k]+"");
        }
        return a;
    }

}

