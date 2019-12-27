package leetcode;

/**
 * https://leetcode.com/problems/unique-paths/
 */
public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 2));
    }
    
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        // first row all 1s
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        
        // first column all 1s
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        
        return dp[m-1][n-1];
    }
    
    public static int uniquePathsR(int m, int n) {
        return uniquePathsRec(m, n, 0, 0);
    }
    
    private static int uniquePathsRec(int m, int n, int row, int col) {
        if (row == m-1 && col == n-1)
            return 1;
        if (row >= m || col >= n)
            return 0;
        int right = uniquePathsRec(m, n, row, col+1);
        int down = uniquePathsRec(m, n, row+1, col);
        return right + down;
    }
}
