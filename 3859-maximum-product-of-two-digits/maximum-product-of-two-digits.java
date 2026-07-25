// Maximum Product of Two Digits
class Solution {
    public int maxProduct(int n) {
        int digit1 = 0;
        int digit2 = 0;
        while(n > 0) {
            int rem = n % 10;
            if(rem >= digit1) {
                digit2 = digit1;
                digit1 = rem;
            }
            else if(rem > digit2) {
                digit2 = rem;
            }
            n = n / 10;
        }
        return digit1 * digit2;
    }
}
          