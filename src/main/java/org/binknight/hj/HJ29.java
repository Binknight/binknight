package org.binknight.hj;

import java.util.Scanner;

public class HJ29 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            System.out.println(new String(encrypt(scanner.nextLine().toCharArray())));
            System.out.println(new String(decrypted(scanner.nextLine().toCharArray())));
        }
    }

    private static char[] decrypted(char[] c1) {
        for (int i = 0; i < c1.length; i++) {
            char c = c1[i];
            if(c <= 'Z' && c> 'A'){
                char x1 = (char) (c-1);
                c = Character.toLowerCase(x1);
            }else if(c <= 'z' && c> 'a'){
                char x2 = (char) (c -1);
                c = Character.toUpperCase(x2);
            }else if (c == 'A'){
                c = 'z';
            }else if (c == 'a'){
                c = 'Z';
            }else if (c == '0'){
                c = '9';
            }else if (c <= '9' && c> '0'){
                c = (char) (c-1);
            }
            c1[i] = c;
        }
        return c1;
    }

    private static char[] encrypt(char[] c1) {
        for (int i = 0; i < c1.length; i++) {
            char c = c1[i];
            if(c < 'Z' && c>= 'A'){
                char x1 = (char) (c+1);
                c = Character.toLowerCase(x1);
            }else if(c < 'z' && c>= 'a'){
                char x2 = (char) (c +1);
                c = Character.toUpperCase(x2);
            }else if (c == 'Z'){
                c = 'a';
            }else if (c == 'z'){
                c = 'A';
            }else if (c == '9'){
                c = '0';
            }else if (c < '9' && c>= '0'){
                c = (char) (c+1);
            }
            c1[i] = c;
        }
        return c1;
    }
}
