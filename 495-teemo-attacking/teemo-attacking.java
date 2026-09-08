// Teemo Attacking
class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int count = 0;
        for(int i = 0 ; i < timeSeries.length - 1 ; i++) {
            count = count + Math.min(duration , timeSeries[i + 1] - timeSeries[i]);
        }
        count = count + duration;
        return count;
    }
}
       