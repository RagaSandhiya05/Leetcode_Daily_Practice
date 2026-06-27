// Valid Number
class Solution {
    public boolean isNumber(String s) {
        boolean isDot = false;
        boolean ise = false;
        boolean nums = false;
        for(int i = 0 ; i < s.length() ; i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch))
            nums = true;
            else if(ch == '+' || ch == '-') {
                if(i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')
                return false;
            }
            else if(ch == 'e' || ch == 'E') {
                if(ise || !nums)
                return false;
                ise = true;
                nums = false;
            }
            else if(ch == '.') {
                if(isDot || ise)
                return false;
                isDot = true;
            }
            else 
            return false;
        }
        return nums;
    }
}
           