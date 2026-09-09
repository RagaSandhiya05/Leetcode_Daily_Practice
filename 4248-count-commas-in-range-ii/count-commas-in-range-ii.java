// Count Commas in Rnage II
class Solution {
    public long countCommas(long n) {
        long start = 1000;
        long commas = 1;
        long answer = 0;
        while(start <= n) {
            long end = (start > n / 1000) ? n : start * 1000 - 1;
            long count = end - start + 1;
            answer = answer + count * commas;
            start = start * 1000;
            ++commas;
        }
        return answer;
    }
}