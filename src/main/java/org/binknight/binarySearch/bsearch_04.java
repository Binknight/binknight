package org.binknight.binarySearch;

public class bsearch_04 {
    /**
     * 变体四：查找最后一个小于等于给定值的元素
     * @param args
     */
    public static void main(String[] args) {
        int[] n = {1,2,2,5,33,68,120,122};
        int bsearch = bsearch(n, 8, 121);
        System.out.println(bsearch);
    }
    public static int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid =  low + ((high - low) >> 1);
            if (value >= a[mid]) {
                if (mid == n-1 || (value < a[mid+1])) return mid;
                else low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }
}
