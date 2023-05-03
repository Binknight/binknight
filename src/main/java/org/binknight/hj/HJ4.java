package org.binknight.hj;

import java.util.Scanner;

public class HJ4 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();

        int y = line.length()%8;
        if(0 != y){
            for (int i = 0; i < 8-y; i++) {
                line = line + "0";
            }
        }
        for (int i = 0; i < line.length(); i = i+8) {
            String substring = line.substring(i, i + 8);
            System.out.println(substring);
        }

        input.close();

    }
}
