package org.binknight.hj;

import java.util.*;

public class HJ8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.valueOf(scanner.nextLine());

        Map<Integer,Integer> map = new TreeMap<>();
        for (int i = 0; i < count; i++) {
            String dd = scanner.nextLine();
            String[] ind_val = dd.split(" ");
            Integer ind = Integer.valueOf(ind_val[0]);
            Integer val = Integer.valueOf(ind_val[1]);
            if(map.containsKey(ind)){
                Integer old = map.get(ind);
                map.put(ind,old+val);
            }else {
                map.put(ind,val);
            }
        }

        map.entrySet().stream().forEach(e -> {
            System.out.println(e.getKey()+" " +e.getValue());
        });
    }
}
