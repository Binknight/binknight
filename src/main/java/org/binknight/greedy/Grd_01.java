package org.binknight.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Grd_01 {
    /**
     * 在一个非负整数 a 中，我们希望从中移除 k 个数字，让剩下的数字值最小，如何选择移除哪 k 个数字呢？
     *
     * 分析思路：
     * @param args
     */
    public static void main(String[] args) {
        String s = removeKDigits("53026421", 4);
        System.out.println(s);
    }
    public static String removeKDigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }
        StringBuilder sb = new StringBuilder(num);
        for (int i = 0; i < k; i++) {
            int j = 0;
            while (j < sb.length() - 1 && sb.charAt(j) <= sb.charAt(j + 1)) {
                j++;
            }
            sb.delete(j, j + 1);
        }
        // 删除前导零
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.delete(0, 1);
        }
        return sb.toString();
    }
}
