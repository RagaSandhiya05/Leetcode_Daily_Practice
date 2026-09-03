// Construct Uniform Parity Array II
class Solution {
    public boolean uniformArray(int[] nums1) {
        int min = nums1[0];
        int odd = 0;
        for(int X : nums1) {
            min = Math.min(min , X);
            odd = odd | X & 1;
        }
        return (min & 1) == odd;
    }
}
       