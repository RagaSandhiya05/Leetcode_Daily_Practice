// Concatenate Non-Zero Digits and Multiply by Sum I
class Solution {
    public long sumAndMultiply(int n) {
        String s = String.valueOf(n);
        long num = 0;
        long sum = 0;
        for (char c : s.toCharArray()) {
            if (c != '0') {
                num = num * 10 + (c - '0');
                sum += c - '0';
            }
        }
        return num * sum;
    }
}