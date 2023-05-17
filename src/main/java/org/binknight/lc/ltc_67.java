package org.binknight.lc;

import javax.persistence.Convert;
import java.math.BigInteger;
import java.util.Arrays;

public class ltc_67 {
    /**
     * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
     * 输入：a = "1010", b = "1011"
     * 输出："10101"
     * @param args
     */
    public static void main(String[] args) {
        String a = "1010101010101010101010101010101", b = "1010101010101010101010101010101";
        String s = addBinary2(a, b);
        System.out.println(s);
    }
    public static String addBinary(String a, String b) {
        char[] aa = a.length() >=b.length()? a.toCharArray():b.toCharArray();
        char[] bb = a.length() < b.length()? a.toCharArray():b.toCharArray();
        int add = 0;
        StringBuilder sb = new StringBuilder();
        for (int j = aa.length-1, k = bb.length-1; j >= 0; j-- , k--) {
            int s = aa[j]-'0' + add;
            if ( k >= 0) s += (bb[k]-'0');
            if(s>=2) {
                add =1; aa[j] = (s%2+"").toCharArray()[0];
            } else {
                add=0; aa[j] = (s+"").toCharArray()[0];
            }
            sb.append(aa[j]);
        }
        if(add ==1) sb.append(1);
        return sb.reverse().toString();
    }

    public static String addBinary1(String a, String b) {
        String longer = a.length() >= b.length() ? a : b;
        String shorter = a.length() < b.length() ? a : b;
        int add = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = longer.length()-1, j = shorter.length()-1; i >= 0; i-- , j--) {
            int s = (longer.charAt(i)-'0') + (j >= 0? shorter.charAt(j)-'0':0) + add;
            if(s>=2) {
                add =1;sb.append(s%2);
            } else {
                add=0;sb.append(s);
            }
        }
        if(add ==1) sb.append(1);
        return sb.reverse().toString();
    }

    public static String addBinary2(String a, String b) { // 可能会溢出
        return new BigInteger(a,2).add(new BigInteger(b,2)).toString(2);
    }
}
