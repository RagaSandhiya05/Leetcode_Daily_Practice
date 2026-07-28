// Smallest Palindromic Rearrangement I
class Solution {
    public String smallestPalindrome(String s) {
        int freq[] = new int[26];
        for(char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        int n = s.length();
        char ans[] = new char[n];
        int left = 0;
        int right = n - 1;
        for(int i = 0 ; i < 26 ; i++) {
            while(freq[i] >= 2) {
                ans[left++] = (char) ('a' + i);
                ans[right--] = (char) ('a' + i);
                freq[i] = freq[i] - 2;
            }
            if(freq[i] == 1) {
                ans[n / 2] = (char) ('a' + i);
            }
        }
        return new String(ans);
    }
}
           