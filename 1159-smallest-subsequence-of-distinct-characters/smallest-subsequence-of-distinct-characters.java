// Smallest Subsequence of Distinct Characters
class Solution {
    public String smallestSubsequence(String s) {
        int freq[] = new int[26];
        for(char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        boolean inStack[] = new boolean[26];
        StringBuilder stack = new StringBuilder();
        for(char ch : s.toCharArray()) {
            freq[ch - 'a']--;
            if(inStack[ch - 'a']) {
                continue;
            }
            while(stack.length() > 0 && stack.charAt(stack.length() - 1) > ch && freq[stack.charAt(stack.length() - 1) - 'a'] > 0) {
                inStack[stack.charAt(stack.length() - 1) - 'a'] = false;
                stack.deleteCharAt(stack.length() - 1);
            }
            stack.append(ch);
            inStack[ch - 'a'] = true;
        }
        return stack.toString();
    }
}
            