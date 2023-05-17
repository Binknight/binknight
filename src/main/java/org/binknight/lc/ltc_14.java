package org.binknight.lc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class ltc_14 {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        String minStr = Arrays.stream(strs).min(Comparator.comparingInt(String::length)).get();
        String sub = "";
        for (int i = 0; i < minStr.length(); i++) {
            final int k = i;
            final String r = sub;
            boolean b = Arrays.stream(strs).allMatch(a -> a.contains(r + minStr.charAt(k) + ""));
            if(!b) break;
            sub += minStr.charAt(k);
        }

        System.out.println(sub);
    }
}
