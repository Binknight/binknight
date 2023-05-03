package org.binknight.hj;

import java.util.Scanner;

public class HJ65 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        if(a.length() <= b.length()){
            extracted(a, b);
        }else {
            extracted(b, a);
        }
    }

    private static void extracted(String a, String b) {
        for (int i = a.length(); i <= a.length(); i--) {
            for (int j = 0; j+i <= a.length(); j++) {
                String sb = a.substring(j, j+i);
                if(b.contains(sb)){
                    System.out.println(sb);
                    return;
                }
            }
        }
    }
}
