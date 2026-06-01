// Minimum Cost of Buying Candies With Discount
class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int ans = 0 , len = cost.length - 1;
        while(len >= 0) {
            ans = ans + cost[len];
            if(len - 1 > -1) {
                ans = ans + cost[len - 1];
                len--;
            }
            len = len - 2;
        }
        return ans;
    }
}
           