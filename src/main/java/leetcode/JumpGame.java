package stuff;

/**
 * https://leetcode.com/problems/jump-game/
 */
public class JumpGame {
    public static void main(String[] args) {
        System.out.println(canJump(new int[] {2,3,1,1,4}));
        System.out.println(canJump(new int[] {3,2,1,0,4}));
    }
    
    public static boolean canJump(int[] nums) {
        boolean[] dp = new boolean [nums.length];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++)
            dp[i] = false;
        
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] == false) {
                continue;
            }
            
            for (int j = i+1; j <= i+nums[i]; j++) {
                if (j >= nums.length)
                    break;
                dp[j] = true;
            }
        }
        
        return dp[dp.length-1];
    }
}
