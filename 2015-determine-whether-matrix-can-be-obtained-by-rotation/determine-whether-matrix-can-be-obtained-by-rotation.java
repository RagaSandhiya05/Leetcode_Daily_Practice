// Determine Whether Matrix Can Be Obtained By Rotation
class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int m = mat.length;
        int n = mat[0].length;
        boolean a = true , b = true , c = true , d = true;
        for(int  i = 0 ; i < m ; i++) {
            for(int j = 0 ; j  < n ; j++) {
                if(a && mat[i][j] != target[i][j]) {
                    a = false;
                }
                if(b && mat[i][j] != target[j][n - 1 - i]) {
                    b = false;
                }
                if(c && mat[i][j] != target[n - 1 - i][n - 1 - j]) {
                    c = false;
                }
                if(d && mat[i][j] != target[n - 1 - j][i]) {
                    d = false;
                }
            }
        }
        return a || b || c || d;
    }
}
               