// Minimum Number of Pushes to Type Word II
class Solution {
    public int minimumPushes(String word) {
        int freq[] = new int[26];
        for(char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }
        Arrays.sort(freq);
        int totalPushes = 0;
        int distinctCount = 0;
        for(int i = 25 ; i >= 0 ; i--) {
            if(freq[i] == 0) 
                break;
                int pushMultiplier = (distinctCount / 8) + 1;
                totalPushes = totalPushes + freq[i] * pushMultiplier;
                distinctCount++;
        }
        return totalPushes;
    }
}