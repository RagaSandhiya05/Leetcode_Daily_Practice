// Word Pattern
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String arr[] = s.split(" ");
        if(pattern.length() != arr.length)
        return false;
        HashMap<Character , String> map1 = new HashMap<>();
        HashMap<String , Character> map2 = new HashMap<>();
        for(int i = 0 ; i < pattern.length() ; i++) {
            char p = pattern.charAt(i);
            String word = arr[i];
            if(map1.containsKey(p)) {
                if(!map1.get(p).equals(word))
                return false;
            }
            else {
                if(map2.containsKey(word))
                return false;
                map1.put(p , word);
                map2.put(word , p);
            }
        }
        return true;
    }
}
           