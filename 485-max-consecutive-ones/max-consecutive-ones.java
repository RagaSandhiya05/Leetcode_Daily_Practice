// Max Consecutive Ones
class Solution {
    public int findMaxConsecutiveOnes(int[] arr) {
        int count = 0;
        int ans = 0;
        int i = 0;
        while(i < arr.length) {
            if(arr[i] == 1) {
                count++;
                i++;
                ans = Math.max(ans , count);
            }
            else if(arr[i] == 0) {
                count = 0;
                i++;
            }
        }
        return ans;
    }
}
         