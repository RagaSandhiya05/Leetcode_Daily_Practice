// Special Position in a Binary Matrix
class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length , n = mat[0].length;
        int row[] = new int[m];
        int cols[] = new int[n];
        for(int i = 0 ; i < m ; i++) {
                for(int j = 0 ; j < n ; j++) {
                    if(mat[i][j] == 1) {
                        row[i]++;
                        cols[j]++;
                    }
                }
        }
            int ans = 0;
            for(int i = 0 ; i < m ; i++) {
                for(int j = 0 ; j < n ; j++) {
                    if(mat[i][j] == 1 && row[i] == 1 && cols[j] == 1) {
                        ans++;
                    }
                }
            }
            return ans;
        }
    }

                    