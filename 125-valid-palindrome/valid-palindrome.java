// Valid Palindrome 
class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^A-Za-z0-9]" , "");
        String rev = "";
        for(int i = s.length() - 1 ; i >= 0 ; i--){
            rev = rev + s.charAt(i);
        }
        if(s.equals(rev)) {
            return true;
        }
        else {
            return false;
        }
    }
}
       