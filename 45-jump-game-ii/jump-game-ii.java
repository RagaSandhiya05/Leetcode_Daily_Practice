// Jump Game II
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0;
        int CurrentEnd = 0;
        int Farthest = 0;
        for(int i = 0 ; i < n - 1 ; i++) {
            Farthest = Math.max(Farthest , i + nums[i]);
            if(i == CurrentEnd) {
                jumps++;
                CurrentEnd = Farthest;
            }
        }
        return jumps;
    }
}
           