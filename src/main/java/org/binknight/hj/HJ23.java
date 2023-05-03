package org.binknight.hj;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HJ23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        char[] chars = line.toCharArray();
        Map<String, Integer> lhm = new LinkedHashMap<>();
        for (int i = 0; i < chars.length; i++) {
            String c = chars[i]+"";
            int count=0;
            for (int j = 0; j < chars.length; j++) {
                if(c.equals(chars[j]+"")){
                    count++;
                }
            }
            lhm.put(c,count);
        }
        String[] re = new String[1];
        re[0] = line;
        Integer minCount = lhm.entrySet().stream().map(c -> c.getValue()).min((a, b) -> a.compareTo(b)).get();
        lhm.entrySet().stream().filter(c -> c.getValue()==minCount).forEach(e -> {
            re[0] = re[0].replace(e.getKey(), "");
        });
        System.out.println(re[0]);
    }
}
