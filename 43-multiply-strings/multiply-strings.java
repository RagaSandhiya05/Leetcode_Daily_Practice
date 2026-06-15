class Solution {
    public String multiply(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        int ans[] = new int[n + m];
        for(int i = n - 1 ; i >= 0 ; i--) {
            for(int j = m - 1 ; j >= 0 ; j--){
                int x = num1.charAt(i) - '0';
                int y = num2.charAt(j) - '0';
                int product = x * y;
                int pos1 = i + j;
                int pos2 = i + j + 1;
                int sum = product + ans[pos2];
                ans[pos2] = sum % 10;
                ans[pos1] = ans[pos1] + sum / 10;
            }
        }
        StringBuilder result = new StringBuilder();
        for(int num : ans) {
            if(!(result.length() == 0 && num == 0)) {
                result.append(num);
            }
        }
        return result.length() == 0 ? "0" : result.toString();
    }
}