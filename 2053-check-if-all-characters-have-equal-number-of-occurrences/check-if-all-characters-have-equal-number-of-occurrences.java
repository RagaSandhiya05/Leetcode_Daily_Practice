// Check if All Characters Have Equal Number of Occurences
class Solution {
    public boolean areOccurrencesEqual(String s) {
        final int[] counts = new int[26];
        for(int i = 0 ; i < s.length() ; i++)
        counts[s.charAt(i) - 'a']++;
        int count = counts[s.charAt(0) - 'a'];
        for(int i = 1 ; i < counts.length ; i++)
        if(count != counts[i] && counts[i] != 0)
        return false;
        return true;
    }
}
    