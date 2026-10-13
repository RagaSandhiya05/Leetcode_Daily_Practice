// Maximum Alternating Sum of Squares 
class Solution {
    public long maxAlternatingSum(int[] nums) {
        int N = nums.length;
        long arr[] = new long[N];
        for(int i = 0 ; i < N ; i++) {
            arr[i] = (long) nums[i] * nums[i];
        }
        Arrays.sort(arr);
        long ans = 0;
        for(int i = 0 ; i < N ; i++) {
            if(i < N / 2) {
                ans = ans - arr[i];
            }
            else {
                ans = ans + arr[i];
            }
        }
        return ans;
    }
}
           