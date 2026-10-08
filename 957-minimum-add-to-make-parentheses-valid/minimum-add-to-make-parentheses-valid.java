// Minimum Add to Make Parentheses Valid
class Solution {
    public int minAddToMakeValid(String s) {
        int opened = 0;
        int added = 0;
        for(char ch : s.toCharArray()) {
            if(ch == '(')
            opened++;
            else if(opened > 0)
            opened--;
            else
            added++;
        }
        return added + opened;
    }
}
        