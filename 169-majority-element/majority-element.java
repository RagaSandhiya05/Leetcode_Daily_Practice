// Majority Element
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int major = 0;
        for(int n : nums){
            if(count == 0){
                major = n;
            }
            if(major == n){
                count++;
            } else {
                count--;
            }
        }
        return major;
    }
}

           