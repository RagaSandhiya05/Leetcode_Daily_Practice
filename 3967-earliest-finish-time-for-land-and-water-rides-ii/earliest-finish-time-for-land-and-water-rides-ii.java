// Earliest Finish Time for Land and Water Rides II
class Solution {
    private int solve(int[] start1 , int[] duration1 , int[] start2 , int[] duration2) {
        int earlierFinish = Integer.MAX_VALUE;
        for(int i = 0 ; i < start1.length ; i++) {
            earlierFinish = Math.min(earlierFinish , start1[i] + duration1[i]);
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i < start2.length ; i++) {
            ans = Math.min(ans , Math.max(earlierFinish , start2[i]) + duration2[i]);
        }
        return ans;
        }
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        return Math.min(solve(landStartTime , landDuration , waterStartTime , waterDuration) , 
        solve(waterStartTime , waterDuration , landStartTime , landDuration));
    }
}