// Number of Different Integers in a String
class Solution {
    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        int start = 0;
        int length = word.length();
        while(start < length) {
            if(!Character.isDigit(word.charAt(start))) {
                start++;
                continue;
            }
            int end = start;
            while(end < length && Character.isDigit(word.charAt(end))) {
                end++;
            }
            while(start < end && word.charAt(start) == '0') {
                start++;
            }
            set.add(word.substring(start , end));
            start = end;
            }
            return set.size();
    }
}