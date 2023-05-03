package org.binknight.hj;
import java.util.Scanner;

public class HJ7 {
    public static void main(String[] args) {
        String num = new Scanner(System.in).nextLine();
        String[] sp = num.split("\\.");
        char c = sp[1].toCharArray()[0];
        if(c >= '5'){
            System.out.println(Integer.valueOf(sp[0])+1);
        }else {
            System.out.println(Integer.valueOf(sp[0]));
        }
    }
}
