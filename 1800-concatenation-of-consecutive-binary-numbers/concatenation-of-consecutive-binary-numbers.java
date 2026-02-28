// Concatenation of Consecutive Binary Numbers
class Solution {
    public int concatenatedBinary(int n) {
        long res = 0;
        int mod = 1000000007;
        for(int i = 1 ; i <= n ; i++) { 
            int temp = i;
            int digit = 0;
            while(temp > 0) {
                digit++;
                temp = temp / 2;
            }
            long power = 1;
            for(int j = 0 ; j < digit ; j++) {
                power = (power * 2) % mod;
            }
            res = (res * power + i) % mod;
        }
        return (int) res;
    }
}
