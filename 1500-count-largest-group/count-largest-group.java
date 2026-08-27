// Count Largest Group
class Solution {
    public int countLargestGroup(int n) {
        Map<Integer , Integer> map = new HashMap<>();
        int MaxSize = 0;
        for(int i = 1 ; i <= n ; i++) {
            int sum = 0;
            int num = i;
            while(num > 0) {
                sum = sum + num % 10;
                num = num / 10;
            }
            map.put(sum , map.getOrDefault(sum , 0) + 1);
            MaxSize = Math.max(MaxSize , map.get(sum));
        }
        int count = 0;
        for(int val : map.values()) {
            if(val == MaxSize)
            count++;
        }
        return count;
    }
}
        