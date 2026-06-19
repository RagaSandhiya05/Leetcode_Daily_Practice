// Find the Highest Altitude
class Solution {
    public int largestAltitude(int[] gain) {
        int MaxHeight = 0;
        int CurrentHeight = 0;
        for(int g : gain) {
            CurrentHeight = CurrentHeight + g;
            MaxHeight = Math.max(MaxHeight , CurrentHeight);
        }
        return MaxHeight;
    }
}