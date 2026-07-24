// Number of Unique XOR Triplets
import java.util.*;
class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;
        HashSet<Integer> pairXor = new HashSet<>();
        for (int i = 0 ; i < n ; i++) {
            for (int j = i + 1 ; j < n ; j++) {
                pairXor.add(nums[i] ^ nums[j]);
            }
        }
        BitSet ans = new BitSet(2048);
        for (int x : nums)
            ans.set(x);
        for (int p : pairXor) {
            for (int x : nums) {
                ans.set(p ^ x);
            }
        }
        return ans.cardinality();
    }
}