// Minimum Element After Replacement With Digit Sum
class Solution {
    public int minElement(int[] nums) {
        int minVal = Integer.MAX_VALUE;
        for(int num : nums) {
            int currentSum = 0;
            while(num > 0) {
                currentSum = currentSum + num % 10;
                num = num / 10;
            }
            minVal = Math.min(minVal , currentSum);
        }
        return minVal;
    }
}
          