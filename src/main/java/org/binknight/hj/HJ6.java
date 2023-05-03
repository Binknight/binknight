package org.binknight.hj;

import java.util.Scanner;

public class HJ6 {
    public static void main(String[] args) {
        int num = new Scanner(System.in).nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sb.append(i).append(" ");
                System.out.println(i);
                num = num / i;
                i--;
            }
        }
        sb.append(num).append(" ");
        System.out.println(sb.toString());
    }
}
