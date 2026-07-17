// Sorted GCD Pair Queries
class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for(int num : nums) {
            max = Math.max(max , num);
        }
            int freq[] = new int[max + 1];
            for(int num : nums) {
                freq[num]++;
            }
            long divisibleCount[] = new long[max + 1];
            for(int g = 1 ; g <= max ; g++) {
                for(int multiple = g ; multiple <= max ; multiple = multiple + g) {
                    divisibleCount[g] += freq[multiple];
                }
            }
            long excatPairs[] = new long[max + 1];
            for(int g = max ; g >= 1 ; g--) {
                long count = divisibleCount[g];
                excatPairs[g] = count * (count - 1) / 2;
                for(int multiple = g * 2 ; multiple <= max ; multiple = multiple + g) {
                    excatPairs[g] = excatPairs[g] - excatPairs[multiple];
                }
            }
            long prefix[] = new long[max + 1];
            for(int g = 1 ; g <= max ; g++) {
                prefix[g] = prefix[g - 1] + excatPairs[g];
            }
            int ans[] = new int[queries.length];
            for(int i = 0 ; i < queries.length ; i++) {
                ans[i] = lowerBound(prefix , queries[i] + 1);
            }
            return ans;
        }
        private int lowerBound(long prefix[] , long target) {
            int left = 1;
            int right = prefix.length - 1;
            while(left < right) {
                int mid = left + (right - left) / 2;
                if(prefix[mid] >= target) {
                    right = mid;
                }
                else {
                    left = mid + 1;
                }
            }
            return left;
        }
}
        