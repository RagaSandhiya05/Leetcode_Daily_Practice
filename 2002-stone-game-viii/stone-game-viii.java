// Stone Game VIII
class Solution {
    public int stoneGameVIII(int[] stones) {
        int N = stones.length;
        for(int i = 1 ; i < N ; i++) {
            stones[i] = stones[i] + stones[i - 1];
        }
        int best = stones[N - 1];
        for(int i = N - 2 ; i >= 1 ; i--) {
            best = Math.max(
                best , 
                stones[i] - best
            );
        }
        return best;
    }
}
          