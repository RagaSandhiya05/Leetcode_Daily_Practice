// Equal Sum Grid Partition II
class Solution {
    static final int M = 100001;
    static int[] A = new int[M];

    static int[] seen = new int[M];
    static int version = 1;

    public static boolean canPartitionGrid(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        int N = r * c;
        long Tsum = 0;

        int idx = 0;
        for (int i = 0; i < r; i++) {
            System.arraycopy(grid[i], 0, A, idx, c);
            idx += c;
        }

        int xMax = 0;
        for (int i = 0; i < N; i++) {
            int x = A[i];
            Tsum += x;
            if (x > xMax) xMax = x;
        }

        version++;
        long top = 0;

        for (int i = 0; i < r - 1; i++) {
            int base = i * c;
            for (int j = 0; j < c; j++) {
                int x = A[base + j];
                top += x;
                seen[x] = version;
            }

            long bot = Tsum - top;
            if (top == bot) return true;

            long d = top - bot;
            if (d > 0 && d <= xMax) {
                int di = (int) d;
                if (i > 0 && c > 1) {
                    if (seen[di] == version) return true;
                } else if (A[0] == di || A[(i + 1) * c - 1] == di) {
                    return true;
                }
            }
        }

        version++;
        long bot = 0;

        for (int i = r - 1; i >= 1; i--) {
            int base = i * c;
            for (int j = c - 1; j >= 0; j--) {
                int x = A[base + j];
                bot += x;
                seen[x] = version;
            }

            long topS = Tsum - bot;
            long d = bot - topS;

            if (d > 0 && d <= xMax) {
                int di = (int) d;
                if ((r - 1 - i) > 0 && c > 1) {
                    if (seen[di] == version) return true;
                } else if (A[i * c] == di || A[N - 1] == di) {
                    return true;
                }
            }
        }

        version++;
        long left = 0;

        for (int j = 0; j < c - 1; j++) {
            for (int i = 0; i < r; i++) {
                int x = A[i * c + j];
                left += x;
                seen[x] = version;
            }

            long right = Tsum - left;
            if (left == right) return true;

            long d = left - right;
            if (d > 0 && d <= xMax) {
                int di = (int) d;
                if (r > 1 && j > 0) {
                    if (seen[di] == version) return true;
                } else if (A[0] == di || A[(r - 1) * c + j] == di) {
                    return true;
                }
            }
        }

        version++;
        long right = 0;

        for (int j = c - 1; j >= 1; j--) {
            for (int i = 0; i < r; i++) {
                int x = A[i * c + j];
                right += x;
                seen[x] = version;
            }

            long leftS = Tsum - right;
            long d = right - leftS;

            if (d > 0 && d <= xMax) {
                int di = (int) d;
                if (r > 1 && (c - 1 - j) > 0) {
                    if (seen[di] == version) return true;
                } else if (A[j] == di || A[N - 1] == di) {
                    return true;
                }
            }
        }
        return false;
    }
}