package org.binknight.dp;

public class dp_02 {
    /**
     * 问题：
     * 假设我们有几种不同币值的硬币 v1，v2，……，vn（单位是元）。如果我们要支付 w 元，求最少需要多少个硬币。1
     * 比如，我们有 3 种不同的硬币，1 元、3 元、5 元，我们要支付 9 元，最少需要 3 个硬币（3 个 3 元的硬币）
     * @param args
     */
    public static void main(String[] args) {
        int sum = 9;
        minCoinsCounts(100);
        System.out.println(minCoinsCounts1(9));
    }

    private static void minCoinsCounts(int sum) {
        int[] s = new int[sum +1];
        s[1] =1;s[2] =2;s[3] =1;s[4] =2;s[5] =1;
        for (int i = 6; i <= sum; i++) {
            s[i] = 1+ Math.min(Math.min(s[i-1],s[i-3]),s[i-5]);
        }
        System.out.println(s[sum]);
    }

    private static int minCoinsCounts1(int sum) {
        int c1 = sum%5;
        if(c1==0) return sum/5;
        int count = sum/5;
        if(c1%3==0) return count+c1/3;
        count +=c1/3+c1%3;
        return count;
    }

}
