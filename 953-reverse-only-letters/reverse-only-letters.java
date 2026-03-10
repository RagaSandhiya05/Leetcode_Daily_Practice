// Reverse Only Letters
class Solution {
    public String reverseOnlyLetters(String s) {
        String rev = "";
        for(int i = s.length() - 1 ; i >= 0 ; i--) {
            char ch = s.charAt(i);
            if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
                rev = rev + ch;
            }
        }
        String result = "";
        int j = 0;
        for(int i = 0 ; i < s.length() ; i++) {
            char ch = s.charAt(i);
            if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
                result = result + rev.charAt(j);
                j++;
            }
            else {
                result = result + ch;
            }
        }
        return result;
    }
}
           