// Keyboard Row
class Solution {
    public String[] findWords(String[] words) {
        ArrayList<String> ans = new ArrayList<>();
        String first = "qwertyuiop";
        String second = "asdfghjkl";
        String third = "zxcvbnm";
        for(String i : words) {
        if(isinrow(i , first) || isinrow(i , second) || isinrow(i , third)) 
            ans.add(i);
        }
        return ans.toArray(new String[0]);
    }
    private boolean isinrow(String s , String row) {
        for(char c : s.toCharArray()) {
            if(row.indexOf(Character.toLowerCase(c)) == -1) {
                return false;
            }
        }
        return true;
    }
}