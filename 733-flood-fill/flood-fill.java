// Flood Fill
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int target = image[sr][sc];
        if(target == color) {
            return image;
        }
        dfs(sr , sc , image , target , color);
        return image;
    }
    public void dfs(int i , int j , int image[][] , int target , int color) {
        if(i < 0 || i >= image.length || j < 0 || j >= image[0].length) {
            return;
        }
        if(image[i][j] != target) {
            return;
        }
        image[i][j] = color;
        dfs(i - 1 , j , image , target , color);
        dfs(i + 1 , j , image , target , color);
        dfs(i , j - 1 , image , target , color);
        dfs(i , j + 1 , image , target , color);
    }
}
      