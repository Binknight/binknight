package org.binknight.binarySearch;

public class Bsearch_05 {
    public static void main(String[] args) {
        int[] n = {1,2,2,5,33,68,120,122};
        int solution = solution(n, 120);
        System.out.println(solution);
    }
    public static int solution(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        while (e >= s){
            int mid = s + (e-s)/2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < nums[e]) {
                if (target < nums[mid] || target > nums[e]) {
                    e = mid - 1;
                } else s = mid + 1;
            } else {
                if (target < nums[s] || target > nums[mid]) {
                    s = mid + 1;
                } else e = mid - 1;
            }
        }
        return -1;
    }
}
