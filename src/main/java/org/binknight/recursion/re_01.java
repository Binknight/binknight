package org.binknight.recursion;

import java.util.Scanner;

/**
 * 递归需要满足的三个条件
 *  1. 一个问题可以分解为几个子问题的解
 *  2. 这个问题和子问题除了计算规模不同，求解思路完全一样
 *  3. 该问题存在递归终止条件
 *
 *  如何来写递归代码？我个人觉得，写递归代码最关键的是写出递推公式，找到终止条件，剩下将递推公式转化为代码就很简单了。
 */
public class re_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int f = f(n);
        System.out.println(f);
    }

    private static int f(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        return f(n-1) + f(n-2);
    }
}
