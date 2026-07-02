// Check If String Is a Prefix of Array
class Solution {
    public boolean isPrefixString(String s, String[] words) {
        int WordIndex = 0;
        int CharIndex = 0;
        for(int i = 0 ; i < s.length() ; i++) {
            char ch = s.charAt(i);
            if(WordIndex == words.length) {
                return false;
            }
            char ch2 = words[WordIndex].charAt(CharIndex++);
            if(ch != ch2) {
                return false;
            }
            if(CharIndex == words[WordIndex].length()) {
                WordIndex++;
                CharIndex = 0;
            }
        }
        return CharIndex == 0;
    }
}
          