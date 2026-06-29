// Greatest English Letter in Upper and Lower Case
class Solution {
    public String greatestLetter(String s) {
        for (char ch = 'Z'; ch >= 'A'; ch--) {
            if (s.indexOf(ch) != -1 && s.indexOf((char)(ch + 32)) != -1) {
                return String.valueOf(ch);
            }
        }
        return "";
    }
}