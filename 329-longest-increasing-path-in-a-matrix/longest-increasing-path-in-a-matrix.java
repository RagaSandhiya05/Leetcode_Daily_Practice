// Longest Increasing Path in a Matrix
class Solution {
    private int dp[][];
    private int matrix[][];
    private int m , n;
    private int dr[] = {-1 , 1 , 0 , 0};
    private final int dc[] = {0 , 0 , -1 , 1};
    public int longestIncreasingPath(int matrix[][]) {
        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
        dp = new int[m][n];
        int answer = 0;
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                answer = Math.max(answer , dfs(i , j));
            }
        }
        return answer;
    }
    private int dfs(int row , int col) {
        if(dp[row][col] != 0) {
            return dp[row][col];
        }
        int maxLength = 1;
        for(int k = 0 ; k < 4 ; k++) {
            int newRow = row + dr[k];
            int newCol = col + dc[k];
            if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && matrix[newRow][newCol] > matrix[row][col]) {
                maxLength = Math.max(maxLength , 1 + dfs(newRow , newCol));
            }
        }
        dp[row][col] = maxLength;
        return maxLength;
    }
}
          