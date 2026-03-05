// Minimum Changes To Make Alternating Binary String
class Solution {
    public int minOperations(String s) {
        int Zero = 0;
        int One = 0;
        for(int i = 0 ; i < s.length() ; i++) {
            if(i % 2 == 0) {
                if(s.charAt(i) != '0') 
                Zero++;
                if(s.charAt(i) != '1')
                    One++;
            }
            else {
                if(s.charAt(i) != '1')
                Zero++;
                if(s.charAt(i) != '0')
                One++;
            }
        }
        return Math.min(Zero , One);
    }
}
            