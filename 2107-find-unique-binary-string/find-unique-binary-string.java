// Find Unique Binary String
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(String num : nums) {
            set.add(Integer.parseInt(num , 2));
        }
        for(int i = 0 ; i < (1 << n) ; i++) {
            if(!set.contains(i)) {
                String bin = Integer.toBinaryString(i);
                while(bin.length() < n) {
                    bin = "0" + bin;
                }
                return bin;
            }
        }
        return "";
    }
}
               