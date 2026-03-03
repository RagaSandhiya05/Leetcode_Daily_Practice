// Rotate String
class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) {
            return false;
        }
        String result = s + s;
        return result.contains(goal);
    }
}
       