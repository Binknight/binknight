package org.binknight.lc;

public class ltc_09 {
    public static void main(String[] args) {
        boolean palindrome = isPalindrome(10);
    }
    public static boolean isPalindrome(int x) {
        if(x < 0) return false;
        StringBuilder sb = new StringBuilder(x);
        String orig = sb.toString();
        String result = sb.reverse().toString();
        return orig.equals(result);
    }
}
