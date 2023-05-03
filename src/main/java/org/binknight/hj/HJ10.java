package org.binknight.hj;

import java.util.HashSet;
import java.util.Scanner;

public class HJ10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        char[] chars = line.toCharArray();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            set.add(chars[i]);
        }
        System.out.println(set.stream().count());
    }
}
