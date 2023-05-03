package org.binknight.hj;

import java.util.Scanner;
import java.util.stream.Stream;

public class HJ20 {
    // 长度<=8, 大小写字母，数字，符号至少三种，符号不包含空格和换行
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        f:while (scanner.hasNext()) {
            String line = scanner.nextLine();
            // 判断长度
            if (line.length() < 8) {
                System.out.println("NG");
                continue;
            }

            //判断字母数字符号
            char[] chars = line.toCharArray();
            boolean hasLowerAlp = false;
            boolean hasUpperAlp = false;
            boolean hasNum = false;
            boolean hasSym = false;
            boolean hasDuplicated = false;
            for (int i = 0; i < chars.length; i++) {
                Integer integer = Integer.valueOf(chars[i]);
                if (integer >= 97 && integer <= 122 ) {
                    hasLowerAlp = true;
                } else if (integer >= 65 && integer <= 90  ) {
                    hasUpperAlp = true;
                } else if (integer >= 48 && integer <= 57 ) {
                    hasNum = true;
                } else if (integer != 32 && integer != 10 ) {
                    hasSym = true;
                }
            }
            long count = Stream.of(hasLowerAlp, hasUpperAlp, hasNum, hasSym).filter(c -> c).count();
            if (count < 3) {
                System.out.println("NG");
                continue;
            }

            // 判断重复
            int length = line.length();
            int ii=0;
            int jj=3;
            int step = 3;
            for (int i = 0; i < length-1; i++) {
                if(i > length-jj){
                    i = 0;
                    ii =0;
                    jj = ++step;
                }
                if (step > length){
                    System.out.println("OK");
                    continue f;
                }
                String substring = line.substring(ii, jj);
                if (ii != line.lastIndexOf(substring)) {
                    System.out.println("NG");
                    continue f;
                }
                ii++;
                jj++;
            }
        }
    }
}
