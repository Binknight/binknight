package org.binknight.copilot;

class Test_01 {
    public static void main(String[] args) {
        Test_01 test = new Test_01();
        test.test_01();
        test.test_02();
    }

    // 写出一个循环体，从1-100输出所有的素数
    void test_01() {
        for (int i = 1; i <= 100; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    // 判断一个数是否为素数
    boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < n; i ++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 数组里有三个元素3,5，7，写出一个判断是否可以通过元素累加(可以重复累加)生成10的方法
    boolean isSum(int[] arr, int sum) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        if (sum <= 0) {
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            if (sum % arr[i] == 0) {
                return true;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (isSum(arr, sum - arr[i])) {
                return true;
            }
        }
        return false;
    }

    // implement a method to find the longest non-repeated sub string in a string
    String longestNonRepeatedSubString(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        int start = 0;
        int end = 0;
        int max = 0;
        int[] map = new int[256];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            start = Math.max(start, map[c]);
            end = i;
            max = Math.max(max, end - start + 1);
            map[c] = i + 1;
        }
        return str.substring(start, end + 1);
    }

    // test for longestNonRepeatedSubString
    void test_02() {
        String str = "abcabcbb";
        String subStr = longestNonRepeatedSubString(str);
        System.out.println(subStr);
    }
}
