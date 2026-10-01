// Maximum Nesting Depth of Two Valid Parentheses Strings
class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int N = seq.length();
        int ans[] = new int[N];
        int depth = 0;
        for(int i = 0 ; i < N ; i++) {
            if(seq.charAt(i) == '(') {
                depth++;
                ans[i] = depth % 2;
            }
            else {
                ans[i] = depth % 2;
                depth--;
            }
        }
        return ans;
    }
}
           