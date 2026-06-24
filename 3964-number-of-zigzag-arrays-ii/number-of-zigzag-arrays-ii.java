// Number of ZigZag Arrays II
class Solution {
    private static final long MOD = 1_000_000_007L;
    public int zigZagArrays(int n , int l , int r) {
        int m = r - l + 1;
        if(n == 1)
            return m;
        int size = 2 * m;
        long T[][] = new long[size][size];
        for(int x = 0 ; x < m ; x++) {
            for(int y = x + 1 ; y < m ; y++) {
                T[m + y][x] = 1;
            }
            for(int y = 0 ; y < x ; y++) {
                T[y][m + x] = 1;
            }
        }
        long P[][] = matrixPower(T , n - 1);
        long startUp[] = new long[size];
        long startDown[] = new long[size];
        for(int i = 0 ; i < m ; i++) {
            startUp[i] = 1;
            startDown[m + i] = 1;
        }
        long ans = 0;
        long res1[] = multiply(P , startUp);
        long res2[] = multiply(P , startDown);
        for(int i = 0 ; i < size ; i++) {
            ans = (ans + res1[i] + res2[i]) % MOD;
        }
        return (int)ans;
    }
    private long[][] matrixPower(long mat[][] , long exp) {
        int n = mat.length;
        long result[][] = new long[n][n];
        for(int i = 0 ; i < n ; i++) {
            result[i][i] = 1;
        }
        while(exp > 0) {
            if((exp & 1) == 1) {
                result = multiply(result , mat);
            }
            mat = multiply(mat , mat);
            exp >>= 1;
        }
        return result;
    }
    private long[][] multiply(long A[][] , long B[][]) {
        int n = A.length;
        long C[][] = new long[n][n];
        for(int i = 0 ; i < n ; i++) {
            for(int k = 0 ; k < n ; k++) {
                if(A[i][k] == 0)
                    continue;
                long val = A[i][k];
                for(int j = 0 ; j < n ; j++) {
                    C[i][j] = (C[i][j] + val * B[k][j]) % MOD;
                }
            }
        }
        return C;
    }
    private long[] multiply(long A[][] , long V[]) {
        int n = A.length;
        long res[] = new long[n];
        for(int i = 0 ; i < n ; i++) {
            long sum = 0;
            for(int j = 0 ; j < n ; j++) {
                sum = (sum + A[i][j] * V[j]) % MOD;
            }
            res[i] = sum;
        }
        return res;
    }
}