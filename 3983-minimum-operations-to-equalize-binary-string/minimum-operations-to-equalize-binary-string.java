// Minimum Operations to Equalize Binary String
class Solution {
    public int minOperations(String s, int k) {
        int n = s.length();
        TreeSet<Integer>[] ts = new TreeSet[2];
        Arrays.setAll(ts , i -> new TreeSet<>());
        for(int i = 0 ; i <= n ; i++) {      
            ts[i % 2].add(i); 
        }
        int cnt0 = 0;
        for(char ch : s.toCharArray()) {
            if(ch == '0') {
                cnt0++;
            }
        }
        ts[cnt0 % 2].remove(cnt0);
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(cnt0);
        int ans = 0;
        while(!queue.isEmpty()) {
            for(int size = queue.size() ; size > 0 ; --size) {
                int curr = queue.poll();
                if(curr == 0) {
                    return ans;
                }
                int l = curr + k - 2 * Math.min(curr , k);
                int r = curr + k - 2 * Math.max(k - n + curr , 0);
                TreeSet<Integer> tree = ts[l % 2];
                Integer next = tree.ceiling(l);
                while(next != null && next <= r) {
                    queue.offer(next);
                    tree.remove(next);
                    next = tree.ceiling(l);
                }
            }
            ans++;
        }
        return -1;
    }
}
              