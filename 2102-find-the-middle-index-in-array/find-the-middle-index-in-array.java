// Find the Middle Index in Array
class Solution {
    public int findMiddleIndex(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0 ; i < n ; i++) {
            sum = sum + nums[i];
        }
        int left = 0;
        for(int i = 0 ; i < n ; i++) {
            sum = sum - nums[i];
            if(left == sum) {
                return i;
            }
            left = left + nums[i];
        }
        return -1;
    }
}