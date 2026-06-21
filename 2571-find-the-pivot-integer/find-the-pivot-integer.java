// Find the Pivot Integer
class Solution {
    public int pivotInteger(int n) {
        int TotalSum = n * (n + 1) / 2;
        int x = (int) Math.sqrt(TotalSum);
        if(x * x == TotalSum) {
            return x;
        }
        return -1;
    }
}