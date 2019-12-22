package leetcode;

/**
 * https://leetcode.com/problems/word-search/
 */
public class WordSearch {
    private static boolean[][] visited;
    
    public static void main(String[] args) {
        char[][] grid = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};

        char[][] grid2 = { { 'a', 'a' } };

        System.out.println(exist(grid, "ABCB"));
    }
    
    private static boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && search(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private static boolean search(char[][] board, String word, int r, int c, int index) {
        if (index == word.length())
            return true;
        if (!isSafe(board, r, c))
            return false;
        
        visited[r][c] = true;
        boolean result = false;
        if (word.charAt(index) == board[r][c]) {
            result = result || search(board, word, r+1, c, index+1);
            result = result || search(board, word, r-1, c, index+1);
            result = result || search(board, word, r, c+1, index+1);
            result = result || search(board, word, r, c-1, index+1);
        }
        
        visited[r][c] = false;
        return result;
    }
    
    private static boolean isSafe(char[][] board, int r, int c) {
        if (r >= board.length || r < 0)
            return false;
        if (c >= board[0].length || c < 0)
            return false;
        if (visited[r][c])
            return false;
        return true;
    }
}
