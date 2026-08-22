// Check Divisibility by Digit Sum and Product
class Solution {
    public boolean checkDivisibility(int n) {
        int Original = n;
        int DigitSum = 0;
        int DigitProduct = 1;
        while(n > 0) {
            int Digit = n % 10;
            DigitSum = DigitSum + Digit;
            DigitProduct = DigitProduct * Digit;
            n = n / 10;
        }
        int Divisor = DigitSum + DigitProduct;
        return Original % Divisor == 0;
    }
}

       