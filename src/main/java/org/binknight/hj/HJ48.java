package org.binknight.hj;

import java.util.LinkedList;
import java.util.Scanner;

public class HJ48 {
    public static void main(String[] args) {
        // 构造过程，例如输入一行数据为:
        // 5 2 3 2 4 3 5 2 1 4 3
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] sp = line.split(" ");
        LinkedList<String> rr = new LinkedList<>();
        rr.add(sp[1]);
        for (int i = 0; i < 2*(Integer.parseInt(sp[0])-1); i+=2) {
            String s1 = sp[i+2]; // 2 3 4 5 6
            String s2 = sp[i+3]; // 3 4 5 6 7
            for (int j = 0; j < rr.size(); j++) {
                if(s2.equals(rr.get(j))){
                    rr.add(j+1,s1);
                }
            }
        }

        for (int i = 0; i < rr.size(); i++) {
            if (rr.get(i).equals(sp[sp.length-1])){
                rr.remove(i);
                break;
            }
        }
        // 删除指定元素
        rr.forEach(f -> System.out.print(f + " "));
    }
}
