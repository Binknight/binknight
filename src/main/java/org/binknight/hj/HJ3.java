package org.binknight.hj;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HJ3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); // 3
        int[] ii = new int[n];

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(input.nextInt());
        }

        set.stream().sorted().forEach(System.out::println);
        input.close();

    }
}
