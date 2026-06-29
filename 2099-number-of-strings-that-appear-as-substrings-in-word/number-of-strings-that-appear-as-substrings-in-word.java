// Number of Strings That Appear as Substrings in Word
class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for(String pattern : patterns) {
            if(word.indexOf(pattern) != -1) {
                count++;
            }
        }
        return count;
    }
}
   