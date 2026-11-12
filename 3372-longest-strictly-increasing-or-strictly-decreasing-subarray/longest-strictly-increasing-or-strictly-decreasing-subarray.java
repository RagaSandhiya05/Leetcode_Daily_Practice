// Longest Strictly Increasing or Strictly Decreasing Subarray
class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int N = nums.length;
        int MaxLen = 1;
        int inc = 1;
        int dec = 1;
        for(int i = 1 ; i < N ; i++) {
            if(nums[i] > nums[i - 1]) {
                inc++;
                dec = 1;
            }
            else if(nums[i] < nums[i - 1]) {
                dec++;
                inc = 1;
            }
            else {
                inc = 1;
                dec = 1;
            }
            MaxLen = Math.max(MaxLen, Math.max(inc , dec));
        }
        return MaxLen;
    }
}
           