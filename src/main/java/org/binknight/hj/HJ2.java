package org.binknight.hj;

import java.util.Scanner;

public class HJ2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] chars = in.nextLine().toCharArray();
        String a = in.nextLine();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (a.equalsIgnoreCase(chars[i]+"")){
                count++;
            };
        }
        System.out.println(count);
        in.close();
    }
}
