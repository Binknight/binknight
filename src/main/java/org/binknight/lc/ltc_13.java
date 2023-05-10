package org.binknight.lc;

import java.util.HashMap;

public class ltc_13 {
    /**
     *         I             1
     *         V             5
     *         X             10
     *         L             50
     *         C             100
     *         D             500
     *         M             1000
     * @param args
     */
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        String s = "MCMXCIV";
        int sum = 0;
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if(i+1 == c.length){
                sum += map.get(c[i]+"");
                break;
            };
            if(c[i] == 'I' && c[i+1] == 'V') {
                sum +=4;
                i++;
            }else if(c[i] == 'I' && c[i+1] == 'X') {
                sum +=9;
                i++;
            } else if(c[i] == 'X' && c[i+1] == 'L') {
                sum +=40;
                i++;
            }else if(c[i] == 'X' && c[i+1] == 'C') {
                sum +=90;
                i++;
            }else if(c[i] == 'C' && c[i+1] == 'D') {
                sum +=400;
                i++;
            }else if(c[i] == 'C' && c[i+1] == 'M') {
                sum +=900;
                i++;
            }else {
                //sum += map.get(c[i]+"");
                switch (c[i]){
                    case 'I': sum += 1;
                    case 'V': sum += 5;
                    case 'X': sum += 10;
                    case 'L': sum += 50;
                    case 'C': sum += 100;
                    case 'D': sum += 500;
                    case 'M': sum += 1000;
                };
            }
        }
        System.out.println(sum);
    }
}
