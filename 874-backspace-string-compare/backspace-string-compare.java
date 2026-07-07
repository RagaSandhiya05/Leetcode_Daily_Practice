// Backspace String Compare
class Solution {
    public boolean backspaceCompare(String s , String t) {
        return back(s).equals(back(t));
    }
    public String back(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        if(s.charAt(0) != '#') {
            sb.append(s.charAt(0));
            count++;
        }
        for(int i = 1 ; i < s.length() ; i++) {
            if(s.charAt(i) == '#' && count > 0) {
                count--;
                sb.delete(count , s.length());
            }
            else if(s.charAt(i) != '#' && count >= 0) {
                sb.append(s.charAt(i));
                count++;
            }
        }
        return sb.toString();
    }
}
           