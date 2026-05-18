// Jump Game IV
class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if(n == 1)
        return 0;
        HashMap<Integer , ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++) {
            map.computeIfAbsent(arr[i] , k -> new ArrayList<>()).add(i);
        }
        boolean visited[] = new boolean[n];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        visited[0] = true;
        int steps = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size --> 0) {
                int curr = queue.poll();
                if(curr == n - 1)
                return steps;
                int left = curr - 1;
                if(left >= 0 && !visited[left]) {
                    visited[left] = true;
                    queue.offer(left);
                }
                int right = curr + 1;
                if(right < n && !visited[right]) {
                    queue.offer(right);
                }
                ArrayList<Integer> list = map.get(arr[curr]);
                if(list != null) {
                    for(int idx : list) {
                        if(!visited[idx]) {
                            visited[idx] = true;
                            queue.offer(idx);
                        }
                    }
                    map.remove(arr[curr]);
                }
            }
            steps++;
        }
        return -1;
    }
}
                       