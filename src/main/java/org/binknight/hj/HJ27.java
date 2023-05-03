package org.binknight.hj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HJ27 {
    public static void main(String[] args) {
        // 读取输入参数 个数n, 单词数组，单词x， 第k个兄弟单词
        Scanner sc = new Scanner(System.in);
        String[] in = sc.nextLine().split(" ");
        int n = Integer.parseInt(in[0]);
        String o = in[n+1];
        int k = Integer.parseInt(in[n+2]);
        String[] bros = new String[n];
        for (int i = 1; i <= n; i++) {
            bros[i-1] = in[i];
        }

        ArrayList<String> ll = new ArrayList<>();
        // 排序
        char[] chars1 = o.toCharArray();
        Arrays.sort(chars1);
        String o2 = new String(chars1);
        for (int i = 0; i < n; i++) {
            String c1 = bros[i];
            char[] cc= c1.toCharArray();
            Arrays.sort(cc);
            String c2 = new String(cc);
            if(!o.equals(c1) && o2.equals(c2)){
                ll.add(bros[i]);
            }
        }

        System.out.println(ll.size());
        String[] objects = ll.toArray(new String[0]);
        Arrays.sort(objects);
        if(k <= ll.size() && k> 0){
            System.out.println(objects[k-1]);
        }
    }
}
