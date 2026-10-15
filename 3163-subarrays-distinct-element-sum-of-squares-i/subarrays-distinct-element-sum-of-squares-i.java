// Subarrays Distinct Element Sum of Squares I
class Solution {
    public int sumCounts(List<Integer> nums) {
        int N = nums.size();
        int res = 0;
        for(int i = 0 ; i < N ; i++) {
            Set<Integer> set = new HashSet<>();
            for(int j = i ; j < N ; j++) {
                set.add(nums.get(j));
                int M = set.size();
                res = res + (M * M);
            }
        }
        return res;
    }
}
           