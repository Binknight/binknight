package org.binknight.hj;

import java.util.*;
import java.util.stream.Collectors;

public class HJ41 {
    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        *//**
         * 对于每组测试数据：
         * 第一行：n --- 砝码的种数(范围[1,10])
         * 第二行：m1 m2 m3 ... mn --- 每种砝码的重量(范围[1,2000])
         * 第三行：x1 x2 x3 .... xn --- 每种砝码对应的数量(范围[1,10])
         *//*
        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> w = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> c = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        *//*Integer wmax = w.stream().max((a, b) -> a - b).get();
        Integer wmin = w.stream().max((a, b) -> b - a).get();
        Integer cmax = c.stream().max((a, b) -> a - b).get();
        Integer cmin = c.stream().max((a, b) -> b - a).get();*//*
        int sum = 0;
        ArrayList<Integer> all = new ArrayList<>();
        //if(n>=1 && n <= 10 && wmax <= 2000 && wmin >= 1 && cmin >= 1 && cmax <=10){
            for (int i = 0; i < n; i++) {
                sum+=w.get(i)*c.get(i);
                for (int j = 0; j < c.get(i); j++) {
                    all.add(w.get(i));
                }
            }
        //}
        boolean[] bbb = new boolean[sum+1];
        // {1,1,3,5,6,6}
        for (int i = 0; i <= sum; i++) {
            bbb[i] = groupSum(0,all,i);//0,{1,1,3},1
        }

        int count = 0;
        for (int i = 0; i < bbb.length; i++) {
            if(bbb[i]){
                count++;
            }
        }
        System.out.println(count);

    }

    public static boolean groupSum(int start, List<Integer> nums, int target) {
        if (start >= nums.size())
            return (target == 0);
        if (groupSum(start + 1, nums, target - nums.get(start)))//3,{1,1,3},-4
            return true;
        if (groupSum(start + 1, nums, target))//0,{1,1,3},1
            return true;
        return false;
    }

    public static void main1(String[] args) {
        List<Integer> integers = Arrays.asList(1, 1, 3);
        boolean b = groupSum(0, integers, 1);
        System.out.println(b);
    }*/


    public static void main(String[] args) {
        long aaa = System.currentTimeMillis();
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> w = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> c = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int sum = 0;
        ArrayList<Integer> all = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sum+=w.get(i)*c.get(i);
            for (int j = 0; j < c.get(i); j++) {
                all.add(w.get(i));
            }
        }
        long bbbv = System.currentTimeMillis();
        System.out.println(bbbv-aaa);
        boolean[] bbb = new boolean[sum+1];
        for (int i = 0; i <= sum; i++) {
            bbb[i] = groupSum(0,all,i);//0,{1,1,3},1
        }
        long dddd = System.currentTimeMillis();
        System.out.println(dddd-bbbv);
        int count = 0;
        for (int i = 0; i < bbb.length; i++) {
            if(bbb[i]){
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean groupSum(int start, List<Integer> nums, int target) {
        if (start >= nums.size())
            return (target == 0);
        if (groupSum(start + 1, nums, target - nums.get(start)))//3,{1,1,3},-4
            return true;
        if (groupSum(start + 1, nums, target))//0,{1,1,3},1
            return true;
        return false;
    }
}
