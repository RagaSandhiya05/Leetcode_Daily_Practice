// Finding 3-Digit Even Numbers
class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int freq[] = new int[10];
        for(int d : digits) {
            freq[d]++;
        }
        List<Integer> list = new ArrayList<>();
        for(int num = 100 ; num <= 998 ; num = num + 2) {
            int count[] = new int[10];
            int temp = num;
            count[temp % 10]++;
            temp = temp / 10;
            count[temp % 10]++;
            temp = temp / 10;
            count[temp % 10]++;
            boolean valid = true;
            for(int i = 0 ; i < 10 ; i++) {
                if(count[i] > freq[i]) {
                    valid = false;
                    break;
                }
            }
            if(valid) {
                list.add(num);
            }
        }
        int ans[] = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
       