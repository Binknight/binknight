package org.binknight.hj;

import java.util.Scanner;
import java.util.Stack;

public class HJ70 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c = Integer.valueOf(scanner.nextLine());
        String[][] aaa = new String[c][2];
        for (int i = 0; i < c; i++) {
            String[] a = scanner.nextLine().split(" ");
            aaa[i] = a;
        }
        String p = scanner.nextLine();
        // (AB(CD))
        Long sum = 0L;
        Stack<String[]> stack = new Stack<>();
        for (int i = p.length()-1, j = c-1; i>= 0; i--) {
            if (p.charAt(i) >= 'A' && p.charAt(i) <= 'Z'){
                stack.push(aaa[j]);
                j--;
            } else if (p.charAt(i) == '(') {
                String[] xx1 = stack.pop(); // [10,20]
                String[] xx2 = stack.pop(); // [20,50]

                Integer aa = Integer.valueOf(xx1[0]);
                Integer ab = Integer.valueOf(xx1[1]);
                Integer bb = Integer.valueOf(xx2[1]);
                sum += aa*ab*bb;
                xx1[1] = xx2[1];
                stack.push(xx1);
            }
        }
        System.out.println(sum);
    }
}
