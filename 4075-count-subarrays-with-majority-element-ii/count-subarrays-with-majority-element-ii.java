// Count Subarrays With Majority Element II
class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int prefix = n;
        int freq[] = new int[2 * n + 1];
        freq[n] = 1;
        long less = 0;
        long ans = 0;
        for(int num : nums) {
            if(num == target) {
                less = less + freq[prefix];
                prefix++;
            }
            else {
                prefix--;
                less = less - freq[prefix];
            }
            freq[prefix]++;
            ans = ans + less;
        }
        return ans;
    }
}
           