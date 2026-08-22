// Remove K Digits
class Solution {
    public String removeKdigits(String num , int k) {
      int l = num.length();
      if(k == l) 
      return "0";
      Stack<Character> st = new Stack<>();
      for(char digit : num.toCharArray()) {
        while(!st.isEmpty() && k > 0 && st.peek() > digit) {
            st.pop();
            k--;
        }
        st.push(digit);
      }
      while(!st.isEmpty() && k > 0){
         st.pop();
            k--;
      }
      StringBuilder sb = new StringBuilder();
      while(!st.isEmpty()){
        sb.append(st.pop());
      }
      sb.reverse();
      while(sb.length() > 1 && sb.charAt(0) == '0'){
       sb.deleteCharAt(0);
      }
      return sb.toString();
    }
}