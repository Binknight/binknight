package org.binknight.binarySearch;

public class Bsearch_01 {
    /**
     * 变体1：查找第一个值等于给定值的元素
     * @param args
     */
    public static void main(String[] args) {
        int[] n = {1,2,2,5,33,68,120,122};
        int bsearch = bsearch(n, 7, 2);
        System.out.println(bsearch);
    }
    public static int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid =  low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == 0) || (a[mid - 1] != value)) return mid;
                else high = mid - 1;
            }
        }
        return -1;
    }
}
