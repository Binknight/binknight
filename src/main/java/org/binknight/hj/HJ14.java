package org.binknight.hj;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class HJ14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer count = Integer.parseInt(scanner.nextLine());
        String[] r = new String[count];
        for (int i = 0; i < count; i++) {
            r[i] = scanner.nextLine();
        }
        Arrays.sort(r);
        Stream.of(r).forEach(System.out::println);
    }
}
