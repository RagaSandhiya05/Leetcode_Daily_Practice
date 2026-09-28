// Maximum Nesting Depth of the Parentheses
class Solution {
    public int maxDepth(String s) {
        int depth = 0;
        int MaxDepth = 0;
        for(char ch : s.toCharArray()) {
            if(ch == '(') {
                depth++;
                if(depth > MaxDepth)
                MaxDepth = depth;
            }
            else if(ch == ')') {
                depth--;
            }
        }
        return MaxDepth;
    }
}
           