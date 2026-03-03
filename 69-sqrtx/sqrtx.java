// Sqrt(x)
class Solution {
    public int mySqrt(int x) {
        int low = 0 , high = x , ans = -1;
        while(low <= high) {
            long mid = (low + high) / 2;
            long midSquare = mid * mid;
            if(midSquare == x) 
            return (int)mid;
            else if(midSquare > x) 
            high = (int)mid - 1;
            else {
                ans = (int)mid;
                low = (int)mid + 1;
            }
        }
        return ans;
    }
}
           