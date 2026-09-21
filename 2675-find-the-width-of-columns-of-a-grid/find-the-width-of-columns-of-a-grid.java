// Find the Width of Columns of a Grid
class Solution {
    public int[] findColumnWidth(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        int ans[] = new int[N];
        for(int i = 0 ; i < N ; i++) {
            int max = 0;
            for(int j = 0 ; j < M ; j++) {
                max = Math.max(max , String.valueOf(grid[j][i]).length());
            }
            ans[i] = max;
        }
        return ans;
    }
}
           