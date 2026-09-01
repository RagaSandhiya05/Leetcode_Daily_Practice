// Minimum Moves to Clean the Classroom
class Solution {
    public int minMoves(String[] classroom, int energy) {
        int M = classroom.length;
        int N = classroom[0].length();
        int[][] id = new int[M][N];
        int sr = 0;
        int sc = 0;
        int litterCount = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                char ch = classroom[i].charAt(j);
                if (ch == 'S') {
                    sr = i;
                    sc = j;
                }
                if (ch == 'L') {
                    id[i][j] = litterCount++;
                }
            }
        }
        if (litterCount == 0) {
            return 0;
        }
        int fullMask = (1 << litterCount) - 1;
        boolean[][][][] visited =
            new boolean[M][N][energy + 1][1 << litterCount];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {
            sr, sc, energy, fullMask
        });
        visited[sr][sc][energy][fullMask] = true;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int moves = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] curr = queue.poll();
                int R = curr[0];
                int C = curr[1];
                int E = curr[2];
                int mask = curr[3];
                if (mask == 0) {
                    return moves;
                }
                if (E == 0) {
                    continue;
                }
                for (int d = 0; d < 4; d++) {
                    int nr = R + dr[d];
                    int nc = C + dc[d];
                    if (nr < 0 || nr >= M ||
                        nc < 0 || nc >= N) {
                        continue;
                    }
                    if (classroom[nr].charAt(nc) == 'X') {
                        continue;
                    }
                    char cell = classroom[nr].charAt(nc);
                    int newEnergy = E - 1;
                    if (cell == 'R') {
                        newEnergy = energy;
                    }
                    int newMask = mask;
                    if (cell == 'L') {
                        newMask &= ~(1 << id[nr][nc]);
                    }
                    if (!visited[nr][nc][newEnergy][newMask]) {
                        visited[nr][nc][newEnergy][newMask] = true;
                        queue.offer(new int[] {
                            nr, nc, newEnergy, newMask
                        });
                    }
                }
            }
            moves++;
        }
        return -1;
    }
}

