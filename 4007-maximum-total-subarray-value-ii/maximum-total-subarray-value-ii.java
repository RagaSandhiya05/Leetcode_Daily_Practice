// Maximum Total Subarray Value II
class Solution {
    private int[][] max;
    private int[][] min;
    private int[] lg;
    private int value(int l, int r) {
        int p = lg[r - l + 1];
        int maximum = Math.max(
                max[p][l],
                max[p][r - (1 << p) + 1]
        );
        int minimum = Math.min(
                min[p][l],
                min[p][r - (1 << p) + 1]
        );
        return maximum - minimum;
    }
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        lg = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            lg[i] = lg[i / 2] + 1;
        }
        int m = lg[n] + 1;
        max = new int[m][n];
        min = new int[m][n];
        for (int i = 0; i < n; i++) {
            max[0][i] = nums[i];
            min[0][i] = nums[i];
        }
        for (int j = 1; (1 << j) <= n; j++) {
            int len = 1 << j;
            int half = len >> 1;
            for (int i = 0; i + len <= n; i++) {
                max[j][i] = Math.max(
                        max[j - 1][i],
                        max[j - 1][i + half]
                );
                min[j][i] = Math.min(
                        min[j - 1][i],
                        min[j - 1][i + half]
                );
            }
        }
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(b[0], a[0]));
        for (int l = 0; l < n; l++) {
            pq.offer(new long[]{
                    value(l, n - 1),
                    l,
                    n - 1
            });
        }
        long ans = 0;
        for (int count = 0; count < k && !pq.isEmpty(); count++) {
            long[] cur = pq.poll();
            long val = cur[0];
            int l = (int) cur[1];
            int r = (int) cur[2];
            ans += val;
            if (r > l) {
                pq.offer(new long[]{
                        value(l, r - 1),
                        l,
                        r - 1
                });
            }
        }
        return ans;
    }
}