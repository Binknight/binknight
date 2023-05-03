package org.binknight.hj;

import java.util.Scanner;

public class HJ17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] sp = line.split(";");
        int[] o = {0,0};
        for (int i = 0; i < sp.length; i++) {
            String s = sp[i];
            if (s.startsWith("A") && isValidNumber(s.substring(1))){
                o[0] = o[0]-Integer.valueOf(s.substring(1));
            }else if (s.startsWith("D") && isValidNumber(s.substring(1))){
                o[0] = o[0]+Integer.valueOf(s.substring(1));
            }else if (s.startsWith("W") && isValidNumber(s.substring(1))){
                o[1] = o[1]+Integer.valueOf(s.substring(1));
            }if (s.startsWith("S") && isValidNumber(s.substring(1))){
                o[1] = o[1]-Integer.valueOf(s.substring(1));
            }
        }

        System.out.println(o[0] + "," + o[1]);
    }

    private static boolean isValidNumber(String str) {
        try{
            Integer integer = Integer.valueOf(str);
            return integer < 100 && -100 <integer;
        } catch (RuntimeException e){
            return false;
        }
    }
}
