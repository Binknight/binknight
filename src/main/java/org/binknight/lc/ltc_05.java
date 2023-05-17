package org.binknight.lc;

public class ltc_05 {
    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     *
     * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
     * @param args
     */
    public static void main(String[] args) {
        String s = "11111111111111111111111111111111111111111111111111111111111";
        String s1 = longestPalindrome1(s);
        System.out.println(s1);
    }

    public static String longestPalindrome(String s) {
        String max = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(i,s.length());
            for (int j = 0; j < sub.length(); j++) {
                String subb =sub.substring(0,sub.length()-j);
                sb.append(subb);
                if(subb.equals(sb.reverse().toString())){
                    max = max.length()>=subb.length()?max:subb;
                }
                sb = new StringBuilder();
            }
        }
        return max;

    }

    public static String longestPalindrome1(String s) {
        boolean[][] b = new boolean[s.length()][s.length()];
        int k = 1;
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while((i+k) <= s.length()){
            String sub = s.substring(i, i+k);
            sb.setLength(0);
            StringBuilder reverse = sb.append(sub).reverse();
            if(reverse.toString().equals(sub)){
               b[k-1][i] = true;
            }
            i++;
            if((i+k) > s.length()){
                i=0;
                k++;
            }
        }

        for (int j = b.length-1; j >= 0; j--) {
            boolean[] bb = b[j];
            for (int l = 0; l < bb.length; l++) {
                if(bb[l]){
                    String substring = s.substring(l, l+j+1);
                    return substring;
                }
            }
        }

        return "";

    }

    public String longestPalindrome2(String s) {
        int k = s.length(),i = 0;
        while((i+k) <= s.length()){
            String sub = s.substring(i, i+k);
            if(isPalindrome(sub)) return sub;
            if(((++i)+k) > s.length()){
                i=0; k--;
            }
        }
        return "";
    }

    public static boolean isPalindrome(String str) {// aba
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) return false;
        }
        return true;
    }
}
