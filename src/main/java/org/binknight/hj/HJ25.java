package org.binknight.hj;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HJ25{
    public static void main(String[] args) {
        /**
         * line1: 15 123 456 786 453 46 7 5 3 665 453456 745 456 786 453 123
         * line2: 5 6 3 6 3 0
         */
        Scanner scanner = new Scanner(System.in);
        String i = scanner.nextLine();
        String r = scanner.nextLine();
        ArrayList<String> tt = new ArrayList<>();
        String ic = i.substring(0, i.indexOf(" ")); // 15
        String is = i.substring(i.indexOf(" "));   // 123 456 786 453 46 7 5 3 665 453456 745 456 786 453 123
        String rc = r.substring(0, r.indexOf(" ")); // 5
        String rs = r.substring(r.indexOf(" "));   // 6 3 6 3 0

        // 123 456 786 453 46 7 5 3 665 453456 745 456 786 453 123
        List<String> icl = Stream.of(is.split(" ")).filter(c -> !c.isEmpty()).collect(Collectors.toList());
        // 0 3 6
        List<String> rcl = Stream.of(rs.split(" ")).filter(c -> !c.isEmpty()).distinct().sorted((a,b) -> Integer.parseInt(a)-Integer.parseInt(b)).collect(Collectors.toList());
        LinkedHashMap<String, List> mp = new LinkedHashMap<>();
        long counts = 0;
        for (int k = 0; k < rcl.size(); k++) {
            int count = 0;
            ArrayList<String> ggg = new ArrayList<>();
            for (int j = 0; j < icl.size(); j++) {
                if (!rcl.get(k).isEmpty() && icl.get(j).contains(rcl.get(k))) {
                    count++;
                    ggg.add(j + "");
                    ggg.add(icl.get(j));
                }
            }
            ArrayList<String> gggZ = new ArrayList<>();
            if (!ggg.isEmpty()) {
                gggZ.add(count + "");
                gggZ.addAll(ggg);
                mp.put(rcl.get(k), gggZ);
                counts += count;
            }
        }
        StringJoiner sj = new StringJoiner(" ");
        counts = counts*2 + mp.entrySet().stream().count()*2;
        sj.add(counts + "");
        mp.entrySet().forEach(e -> {
            sj.add(e.getKey());
            List<String> value = e.getValue();
            value.forEach(v -> sj.add(v));
        });
        System.out.print(sj.toString());
    }
}
