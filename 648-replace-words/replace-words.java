// Replace Words
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> st = new HashSet<>(dictionary);
        StringBuilder sb = new StringBuilder();
        String words[] = sentence.split(" ");
        for(String word : words) {
            sb.append(findRoot(word , st)).append(" ");
        }
        return sb.toString().trim();
    }
    private String findRoot(String word , Set<String> st) {
        for(int i = 0 ; i < word.length() ; i++) {
            String root = word.substring(0 , i);
            if(st.contains(root)) {
                return root;
            }
        }
        return word;
    }
}
   