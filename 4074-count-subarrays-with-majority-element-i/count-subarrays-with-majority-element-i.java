// Count Subarrays With Majority Element I
class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        long ans = 0;
        for(int l = 0 ; l < n ; l++) {
            int TargetCount = 0;
            for(int r = l ; r < n ; r++) {
                if(nums[r] == target) {
                    TargetCount++;
                }
                int len = r - l + 1;
                if(TargetCount > len / 2) {
                    ans++;
                }
            }
        }
        return (int) ans;
    }
}
        
        