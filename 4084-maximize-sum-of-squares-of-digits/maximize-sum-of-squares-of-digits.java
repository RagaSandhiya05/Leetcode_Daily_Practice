// Maximize Sum of Squares of Digits
class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(num * 9 < sum) {
            return "";
        }
        int N = sum / 9;
        sum = sum % 9;
        StringBuilder sb = new StringBuilder("9".repeat(N));
        if(sum > 0) {
            sb.append(sum);
        }
        sb.append("0".repeat(num - sb.length()));
        return sb.toString();
    }
}


      