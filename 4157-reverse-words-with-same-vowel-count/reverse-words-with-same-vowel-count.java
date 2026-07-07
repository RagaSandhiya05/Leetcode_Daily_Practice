// Reverse Words With Same Vowel Count
class Solution {
    public String reverseWords(String s) {
        String words[] = s.split(" ");
        String vowels = "aeiou";
        int FirstCount = 0;
        for(char ch : words[0].toCharArray()) {
            if(vowels.indexOf(ch) != -1)
            FirstCount++;
        }
        for(int i = 1 ; i < words.length ; i++) {
            int count = 0;
            for(char ch : words[i].toCharArray()) {
                if(vowels.indexOf(ch) != -1)
                count++;
            }
            if(count == FirstCount) {
                words[i] = new StringBuilder(words[i]).reverse().toString();
            }
        }
        return String.join(" " , words);
    }
}
            