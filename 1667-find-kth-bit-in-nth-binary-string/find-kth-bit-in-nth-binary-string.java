// Find Kth Bit in Nth Binary String
class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder sb = new StringBuilder();
        sb.append(0);
        for(int i = 2 ; i <= n ; i++) {
            sb.append(1);
            for(int j = sb.length() - 2 ; j >= 0 ; j--) {
                if(sb.charAt(j) == '0')sb.append(1);
                else sb.append(0);
            }
        }
        return sb.charAt(k - 1);
    }
}
          