package org.binknight.binarySearch;

public class Bsearch_03 {
    /**
     * 变体三：查找第一个大于等于给定值的元素
     * @param args
     */
    public static void main(String[] args) {
        int[] n = {1,2,2,5,33,68,120,122};
        int bsearch = bsearch(n, 8, 123);
        System.out.println(bsearch);
    }
    public static int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid =  low + ((high - low) >> 1);
            if (value <= a[mid]) {
                if (mid == 0 || (value > a[mid-1])) return mid;
                else high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }
}
