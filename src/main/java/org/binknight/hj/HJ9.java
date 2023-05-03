package org.binknight.hj;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class HJ9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        char[] chars = line.toCharArray();
        Set<Character> st = new LinkedHashSet<>();
        for (int i = chars.length-1; i >= 0; i--) {
            if (!st.contains(chars[i])){
                st.add(chars[i]);
            }
        }
        st.stream().forEach(System.out::print);
    }
}
