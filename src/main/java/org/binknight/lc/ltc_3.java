package org.binknight.lc;

public class ltc_3 {
    public static void main(String[] args) {
        String s = "au";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);

    }

    public static int lengthOfLongestSubstring(String s) {
        if(s.length()==1) return 1;
        int le =0;
        String t = "";
        for (int i = 0; i < s.length(); i++) {
            if(t.contains(s.charAt(i)+"")){
                le = t.length()>le?t.length():le;
                t=t.substring(1,t.length());
                i--;
            }else {
                t+=s.charAt(i);
                if(i==s.length()-1){
                    le = t.length()>le?t.length():le;
                }
            }
        }
        return le;
    }


}
