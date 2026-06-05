// Total Waviness of Numbers in Range II
class Solution {
    char[] digits;
    Pair[][][] memo;
    class Pair {
        long count;
        long sum;
        Pair(long count, long sum) {
            this.count = count;
            this.sum = sum;
        }
    }
    public long totalWaviness(long num1, long num2) {
        return calc(num2) - calc(num1 - 1);
    }
    private long calc(long x) {
        if (x <= 0)
            return 0;
        digits = String.valueOf(x).toCharArray();
        memo = new Pair[digits.length][11][3];
        return dfs(0, 10, 0, true, false).sum;
    }
    private Pair dfs(int pos, int prevDigit, int prevDir,
                     boolean tight, boolean started) {
        if (pos == digits.length) {
            return started ? new Pair(1, 0) : new Pair(0, 0);
        }
        if (!tight && started &&
            memo[pos][prevDigit][prevDir + 1] != null) {
            return memo[pos][prevDigit][prevDir + 1];
        }
        int limit = tight ? digits[pos] - '0' : 9;
        long totalCount = 0;
        long totalSum = 0;
        for (int d = 0; d <= limit; d++) {
            boolean nextTight =
                    tight && (d == (digits[pos] - '0'));
            if (!started && d == 0) {
                Pair child = dfs(pos + 1, 10, 0,
                                 nextTight, false);
                totalCount += child.count;
                totalSum += child.sum;
                continue;
            }
            int nextDir = prevDir;
            int addWave = 0;
            if (!started) {
                nextDir = 0;
            } else {
                if (d > prevDigit)
                    nextDir = 1;
                else if (d < prevDigit)
                    nextDir = -1;
                else
                    nextDir = 0;
                if (prevDir == 1 && nextDir == -1)
                    addWave = 1;
                if (prevDir == -1 && nextDir == 1)
                    addWave = 1;
            }
            Pair child =
                    dfs(pos + 1, d, nextDir,
                        nextTight, true);
            totalCount += child.count;
            totalSum += child.sum +
                        (long) addWave * child.count;
        }
        Pair ans = new Pair(totalCount, totalSum);
        if (!tight && started) {
            memo[pos][prevDigit][prevDir + 1] = ans;
        }
        return ans;
    }
}