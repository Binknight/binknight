package org.binknight.lc;

import java.util.Arrays;

public class ltc_88 {
    /**
     * nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * @param args
     */
    public static void main(String[] args) {
        int[] nums1 = {2,0};
        int[] nums2 = {1};
        //int[] merge = merge(nums1, 3, nums2, 3);
        merge1(nums1, 1, nums2, 1);
        //Arrays.stream(merge).forEach(System.out::print);
    }

    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int[] news = new int[n + m];
        int index_m =0, index_n = 0;
        for (int i = 0; i < n+m; i++) {
            if(index_m < m && index_n < n){
                if(nums1[index_m] < nums2[index_n]){
                    news[i] = nums1[index_m++];
                } else if (nums1[index_m] == nums2[index_n]) {
                    news[i] = nums1[index_m++];
                    news[++i] = nums2[index_n++];
                }else {
                    news[i] = nums2[index_n++];
                }
            }else if (index_m == m && index_n < n){
                news[i] = nums2[index_n++];
            }else if (index_m < m && index_n == n){
                news[i] = nums2[index_m++];
            }else {
                break;
            }
        }
        for (int i = 0; i < news.length; i++) {
            nums1[i] = news[i];
        }
        return news;
    }


    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        if(m <= 0 && n <= 0){
            return;
        }
        if(m ==0 && n>0){
            for(int k=0;k<n;k++){
                nums1[k] = nums2[k];
            }
            return;
        }
        if(m>0 && n ==0){
            return;
        }
        int[] news = new int[n + m];
        int index_m =0, index_n = 0;
        for (int i = 0; i < n+m; i++) {
            if(index_m < m && index_n < n){
                if(nums1[index_m] < nums2[index_n]){
                    news[i] = nums1[index_m++];
                } else if (nums1[index_m] == nums2[index_n]) {
                    news[i] = nums1[index_m++];
                    news[++i] = nums2[index_n++];
                }else {
                    news[i] = nums2[index_n++];
                }
            }else if (index_m == m && index_n < n){
                news[i] = nums2[index_n++];
            }else if (index_m < m && index_n == n){
                news[i] = nums1[index_m++];
            }else {
                break;
            }
        }
        for (int i = 0; i < news.length; i++) {
            nums1[i] = news[i];
        }
    }
}
