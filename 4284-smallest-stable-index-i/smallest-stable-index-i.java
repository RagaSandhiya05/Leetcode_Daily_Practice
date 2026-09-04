// Smallest Stable Index 1
class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int N = nums.length;
        int SuffixMin[] = new int[N];
        SuffixMin[N - 1] = nums[N - 1];
        for(int i = N - 2 ; i >= 0 ; i--) {
            SuffixMin[i] = Math.min(nums[i] , SuffixMin[i + 1]);
        }
        int PrefixMax = nums[0];
        for(int i = 0 ; i < N ; i++) {
            PrefixMax = Math.max(PrefixMax , nums[i]);
            int instability = PrefixMax - SuffixMin[i];
            if(instability <= k) {
                return i;
            }
        }
        return -1;
    }
}
           