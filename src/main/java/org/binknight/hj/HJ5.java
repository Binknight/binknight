package org.binknight.hj;

import java.util.Scanner;

/**
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
 */
public class HJ5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String i = scanner.nextLine();
        // 0~9,A,B,C,D,E，F
        char[] chars = i.toCharArray();
        int len = chars.length;
        long iii = 0L;
        //0xAAF
        for (int j = 2; j < len; j++) {
            int z = len-j;
            long ss= (long) Math.pow(16, z - 1);
            if ('A' == chars[j]){
                iii = iii + ss*10;
            }else if('B' == chars[j]){
                iii = iii + ss*11;
            }else if('C' == chars[j]){
                iii = iii + ss*12;
            }else if('D' == chars[j]){
                iii = iii + ss*13;
            }else if('E' == chars[j]){
                iii = iii + ss*14;;
            }else if('F' == chars[j]){
                iii = iii + ss*15;;
            }else {
                int integer = Integer.valueOf(chars[j]+"");
                iii = iii + ss*integer;
            }
        }

        if ('1'==chars[0]){
            iii = 0-iii;
        }
        System.out.println(iii);
    }
}
