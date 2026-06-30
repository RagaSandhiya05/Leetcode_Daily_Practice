// Number of Substrings Containing All Three Characters
class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int left = 0;
        int count = 0;
        int a = 0;
        int b = 0;
        int c = 0;
        for(int right = 0 ; right < n ; right++) {
            char ch = s.charAt(right);
            if(ch == 'a')
            a++;
            else if(ch == 'b')
            b++;
            else
            c++;
            while(a > 0 && b > 0 && c > 0) {
            count = count + (n - right);
            char LeftChar = s.charAt(left);
            if(LeftChar == 'a')
            a--;
            else if(LeftChar == 'b')
            b--;
            else
            c--;
            left++;
        }
    }
    return count;
    }
}