// Row With Maximum Ones
class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
       int rows = mat.length;
       int cols = mat[0].length;
       int MaxOnes = 0;
       int MaxRow = 0;
       for(int i = 0 ; i < rows ; i++) {
        int Ones = 0;
        for(int j = 0 ; j < cols ; j++) {
            if(mat[i][j] == 1)
            Ones++;
        }
        if(Ones > MaxOnes) {
            MaxOnes = Ones;
            MaxRow = i;
        }
       }
       return new int[]{MaxRow , MaxOnes};
    }
}
        