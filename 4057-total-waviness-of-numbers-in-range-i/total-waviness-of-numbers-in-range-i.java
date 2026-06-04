// Total Waviness of Numbers in Range I
class Solution {
    public int totalWaviness(int num1, int num2) {
        int total = 0;
        for(int num = num1 ; num <= num2 ; ++num) {
            String n = String.valueOf(num);
            if(n.length() < 3)
            continue;
            for(int i = 1 ; i < n.length() - 1 ; ++i) {
                char current = n.charAt(i);
                char prev = n.charAt(i - 1);
                char next = n.charAt(i + 1);
                if((current > prev && current > next) || 
                (current < prev && current < next)) {
                    total++;
                }
            }
        }
        return total;
    }
}
           