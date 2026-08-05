// Remove Methods From Project
class Solution {
    public void func(int u , List<List<Integer>> adj , boolean visited[]) {
        visited[u] = true;
        for(int v : adj.get(u)) {
            if(visited[v])
            continue;
            func(v , adj , visited);
        }
    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) {
            adj.add(new ArrayList<>());
        }
        for(int it[] : invocations) {
            int u = it[0];
            int v = it[1];
            adj.get(u).add(v);
        }
        boolean visited[] = new boolean[n];
        func(k , adj , visited);
        for(int it[] : invocations) {
            int u = it[0];
            int v = it[1];
            if(visited[u])
            continue;
            if(visited[v]) {
                List<Integer> ans = new ArrayList<>();
                for(int i = 0 ; i < n ; i++) {
                    ans.add(i);
                }
                return ans;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) {
            if(!visited[i]) {
                ans.add(i);
            }
        }
        return ans;
    }
}
           