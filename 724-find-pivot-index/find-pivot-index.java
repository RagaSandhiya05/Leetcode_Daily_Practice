// Find Pivot Index
class Solution {
    public int pivotIndex(int[] nums) {
        int TotalSum = 0;
        int LeftSum = 0;
        for(int elements : nums)
        TotalSum = TotalSum + elements;
        for(int i = 0 ; i < nums.length ; LeftSum = LeftSum + nums[i++])
        if(LeftSum * 2 == TotalSum - nums[i])
        return i;
        return -1;
    }
}