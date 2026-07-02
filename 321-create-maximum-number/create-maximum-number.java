// Create Maximum Number
class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] best = new int[k];
        for (int i = Math.max(0, k - n2); i <= Math.min(k, n1); i++) {
            int[] ss1 = pmc(nums1, i);
            int[] ss2 = pmc(nums2, k - i);
            int[] cur = merge(ss1, ss2, k);
            if (greater(cur, 0, best, 0)) {
                best = cur;
            }
        }
        return best;
    }
    private int[] pmc(int[] nums, int t) {
        if (t == 0) return new int[0];
        Deque<Integer> st = new LinkedList<>();
        int toRemove = nums.length - t;
        for (int x : nums) {
            while (!st.isEmpty() && st.peekLast() < x && toRemove > 0) {
                st.removeLast();
                toRemove--;
            }
            st.addLast(x);
        }
        while (toRemove > 0) {
            st.removeLast();
            toRemove--;
        }
        int[] res = new int[t];
        for (int i = 0; i < t; i++) {
            res[i] = st.removeFirst();
        }
        return res;
    }
    private int[] merge(int[] a, int[] b, int k) {
        int[] res = new int[k];
        int i = 0, j = 0, idx = 0;
        while (idx < k) {
            if (greater(a, i, b, j)) {
                res[idx++] = a[i++];
            } else {
                res[idx++] = b[j++];
            }
        }
        return res;
    }
    private boolean greater(int[] a, int i, int[] b, int j) {
        while (i < a.length && j < b.length && a[i] == b[j]) {
            i++;
            j++;
        }
        if (j == b.length) return true;
        if (i == a.length) return false;
        return a[i] > b[j];
    }
}