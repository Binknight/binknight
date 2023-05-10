package org.binknight.lc;

import java.math.BigInteger;

public class Test {
    public static void main(String[] args) {
        //[2,4,3]
        //[5,6,4]
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode listNode = addTwoNumbers(l1, l2);
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String a = getRealNumber(l1);
        String b = getRealNumber(l2);
        BigInteger re = new BigInteger(a).add(new BigInteger(b));
        char[] r = re.toString().toCharArray();
        int len = r.length;
        ListNode node =null;
        for(int i =0; i < len; i++){
            if(i == 0) {
                node = new ListNode(Integer.parseInt(r[i]+""));
            }else{
                node = new ListNode(Integer.parseInt(r[i]+""),node);
            }
        }
        return node;
    }

    static String getRealNumber(ListNode l1){
        StringBuilder sb = new StringBuilder();
        ListNode next = l1.next;
        sb.append(l1.val);
        while(next != null){
            sb.append(next.val);
            next = next.next;
        }
        return sb.reverse().toString();
    }
}

  class ListNode {
    int val;
    ListNode next;
    ListNode() {}
   ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

