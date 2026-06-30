// Palindrome Pairs
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        HashMap<String , Integer> map = new HashMap<>();
        Set<Integer> set = new TreeSet<>();
        int n = words.length;
        for(int i = 0 ; i < n ; i++) {
            map.put(words[i] , i);
            set.add(words[i].length());
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) {
            int length = words[i].length();
            if(length == 1) {
                if(map.containsKey("")) {
                    ans.add(Arrays.asList(i , map.get("")));
                    ans.add(Arrays.asList(map.get("") , i));
                }
                continue;
            }
            String reverse = new StringBuilder(words[i]).reverse().toString();
            if(map.containsKey(reverse) && map.get(reverse) != i)
            ans.add(Arrays.asList(i , map.get(reverse)));
            for(Integer k : set) {
                if(k == length)
                break;
                if(isPalindrome(reverse , 0 , length - 1 - k)) {
                    String str1 = reverse.substring(length - k);
                    if(map.containsKey(str1))
                    ans.add(Arrays.asList(i , map.get(str1)));
                }
                if(isPalindrome(reverse , k , length - 1)) {
                    String str2 = reverse.substring(0 , k);
                    if(map.containsKey(str2))
                    ans.add(Arrays.asList(map.get(str2) , i));
                }
            }
        }
        return ans;
    }
    private boolean isPalindrome(String s , int left , int right) {
        while(left < right)
        if(s.charAt(left++) != s.charAt(right--))
        return false;
        return true;
    }
}
