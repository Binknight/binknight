package org.binknight.hj;

import java.io.IOException;
import java.util.*;

public class HJ68 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sj = Integer.parseInt(scanner.nextLine());
        ArrayList<String> st = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st.add(scanner.nextLine());
        }
        st.stream().sorted((a,b) -> {
            int o11 = Integer.parseInt(a.split(" ")[1]);
            int o22 = Integer.parseInt(b.split(" ")[1]);
            if (sj == 1) return o11-o22;
            else return o22-o11;
        }).forEach(System.out::println);
    }
}
