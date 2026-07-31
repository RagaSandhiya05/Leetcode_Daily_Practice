// Remove All Adjacent Duplicates In String
class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()) {
            if(!stack.isEmpty() && ch == stack.peek()) {
                stack.pop();
            }
            else {
                stack.push(ch);
            }
        }
        StringBuilder result = new StringBuilder();
        for(char ch : stack) {
            result.append(ch);
        }
        return result.toString();
    }
}
       