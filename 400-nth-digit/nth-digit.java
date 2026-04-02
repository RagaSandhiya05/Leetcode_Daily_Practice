// Nth Digit
class Solution {
    public int findNthDigit(int n) {
        int digits = 1;
        long count = 9;
        int start = 1;
        while(n > digits * count) {
            n -= digits * count;
            digits++;
            count = count * 10;
            start = start * 10;
        }
        start = start + (n - 1) / digits;
        String s = Integer.toString(start);
        return Character.getNumericValue(s.charAt((n - 1) % digits));
    }
}
      