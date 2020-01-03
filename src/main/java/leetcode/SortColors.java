package stuff;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sort-colors/
 */
public class SortColors {
    public static void main(String[] args) {
        int[] colors = {2, 1, 1, 2, 1, 0, 1, 2, 0};
        sortColors(colors);
        System.out.println(Arrays.toString(colors));
    }
    
    public static void sortColors(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        int p0 = 0;
        int i = 0;
        int p2 = nums.length-1;
        while (i <= p2) {
            if (nums[i] == 0) {
                swap(nums, i, p0);
                p0++;
            }
            if (nums[i] == 2) {
                swap(nums, i, p2);
                p2--;
                i--;
            }
            i++;
        }
        
    }
    
    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
    
    public static void sortColors2Pass(int[] nums) {
        int red = 0;
        int white = 0;
        int blue = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                red++;
            else if (nums[i] == 1)
                white++;
            else
                blue++;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (red > 0) {
                nums[i] = 0;
                red--;
            } else if (white > 0) {
                nums[i] = 1;
                white--;
            } else if (blue > 0) {
                nums[i] = 2;
                blue--;
            }
        }
    }
}
