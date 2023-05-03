package org.binknight.dp;

import java.util.Arrays;

public class dp_05 {
    public static void main(String[] args) {
        int[] i = {5, 9, 10, 3, 4, 6, 7};
        int count = lengthoflIs(i);
        System.out.println(count);
    }

    public static int lengthoflIs(int[] nums) {
        if(nums == null || nums.length == 0)
        return 0;
        int n = nums .length;int[] dp = new int[n];
        Arrays.fill(dp,1);
        int res = 1;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
