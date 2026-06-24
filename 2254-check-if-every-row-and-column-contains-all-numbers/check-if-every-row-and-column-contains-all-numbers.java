class Solution {
    public boolean checkValid(int[][] matrix) {
        int len = matrix.length;
        for(int i = 0 ; i < len ; i++) {
            HashSet<Integer> Row = new HashSet<>();
            HashSet<Integer> Column = new HashSet<>();
            for(int j = 0 ; j < len ; j++) {
                Row.add(matrix[i][j]);
                Column.add(matrix[j][i]);
            }
            if(Row.size() != len || Column.size() != len)
                return false;
        }
            return true;
    }
}