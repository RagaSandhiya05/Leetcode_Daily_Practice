// Minimum Distance to Type a Word Using Two Fingers
class Solution {
    public int find(int i , int f1 , int f2 , String word , int dp[][][]) {
        int n = word.length();
        if(i >= n)
        return 0;
        
        if(dp[i][f1 + 1][f2 + 1] != -1)
        return dp[i][f1 + 1][f2 + 1];
        
        int val = word.charAt(i) - 'A';
        int x2 = val / 6;
        int y2 = val % 6;
        
        int left = 0;
        int right = 0;

        if(f1 >= 0) {
            int x1 = f1 / 6;
            int y1 = f1 % 6;
            left = Math.abs(x1 - x2) + Math.abs(y1 - y2);
        }
        left = left + find(i + 1 , val , f2 , word , dp);

        if(f2 >= 0) {
            int x1 = f2 / 6;
            int y1 = f2 % 6;
            right = Math.abs(x1 - x2) + Math.abs(y1 - y2);
        }
        right = right + find(i + 1 , f1 , val , word , dp);

        return dp[i][f1 + 1][f2 + 1] = Math.min(left , right);
    }

    public int minimumDistance(String word) {
        int n = word.length();
        int dp[][][] = new int[n][27][27];
        for(int a[][] : dp) {
            for(int b[] : a) {
                Arrays.fill(b , -1);
            }
        }
        return find(0 , -1 , -1 , word , dp);
    }
}

           