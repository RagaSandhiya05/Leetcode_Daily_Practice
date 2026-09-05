// Smallest Stable Index II
class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int MaxSoFar = -1;
        int Cand = 0;
        int Max = 0;
        for(int i = 0 ; i < nums.length ; i++) {
            MaxSoFar = Math.max(MaxSoFar , nums[i]);
            if(Cand == i) 
            Max = MaxSoFar;
            if(nums[i] < Max - k)
            Cand = i + 1;
        }
        return Cand < nums.length ? Cand : -1;
    }
}
        