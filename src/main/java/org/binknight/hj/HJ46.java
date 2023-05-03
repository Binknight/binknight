package org.binknight.hj;

import java.util.Scanner;

public class HJ46 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String strs = scanner.nextLine();
        String len = scanner.nextLine();
        System.out.println(strs.substring(0,Integer.valueOf(len)));
    }
}
