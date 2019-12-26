package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LengthLis {
    public static void main(String[] args) {
        int[] s = {1,3,6,7,9,4,10,5,6};
        System.out.println(lengthOfLIS(s));
    }
    
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && max < dp[j]) {
                    max = dp[j];
                }
            }
            dp[i] = max + 1;
        }
        
        Arrays.sort(dp);
        return dp[dp.length - 1];
    }
    
    public static int lengthOfLISR(int[] nums) {
        return lengthOfLISRec(nums, Integer.MIN_VALUE, 0);
    }
    
    public static int lengthOfLISRec(int[] nums, int prev, int index) {
        if (index == nums.length)
            return 0;
        
        int taken = 0;
        if (nums[index] > prev) {
            taken = 1 + lengthOfLISRec(nums, nums[index], index + 1);
        }
        int notTaken = lengthOfLISRec(nums, prev, index + 1);
        
        return Integer.max(taken, notTaken);
    }
    
}
