package org.binknight.hj;

import java.util.*;
import java.util.stream.Collectors;

public class HJ101 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer count = Integer.valueOf(scanner.nextLine());
        String line = scanner.nextLine();
        String neg = scanner.nextLine();
        ArrayList<Integer> ss = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String[] sp = line.split(" ");
            ss.add(Integer.valueOf(sp[i]));
        }
        List<Integer> ll = ss.stream().sorted().collect(Collectors.toList());
        if (neg.equals("0")){
            for (int i = 0; i < ll.size(); i++) {
                System.out.print(ll.get(i)+" ");
            }
        }else if (neg.equals("1")){
            for (int i = ll.size()-1; i >= 0; i--) {
                System.out.print(ll.get(i)+" ");
            }
        }
    }
}
