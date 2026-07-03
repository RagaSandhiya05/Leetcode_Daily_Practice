// Network Recovery Pathways
class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        List<int[]>[] graph = new ArrayList[n];
        for(int i = 0 ; i < n ; i++)
        graph[i] = new ArrayList<>();
        int indegree[] = new int[n];
        int maxWeight = 0;
        for(int e[] : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];
            graph[u].add(new int[]{v , w});
            indegree[v]++;
            maxWeight = Math.max(maxWeight , w);
        }
        Queue<Integer> q = new ArrayDeque<>();
        int topo[] = new int[n];
        int index = 0;
        int deg[] = indegree.clone();
        for(int i = 0 ; i < n ; i++) {
            if(deg[i] == 0)
            q.offer(i);
        }
        while(!q.isEmpty()) {
            int u = q.poll();
            topo[index++] = u;
            for(int edge[] : graph[u]) {
                int v = edge[0];
                if(--deg[v] == 0)
                q.offer(v);
            }
        }
        int low = 0;
        int high = maxWeight;
        int ans = -1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(check(mid , graph , topo , online , k , n)) {
                ans = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return ans;
    }
    private boolean check(int limit , List<int[]>[] graph , int topo[] , boolean online[] , long k , int n) {
        long INF = Long.MAX_VALUE / 4;
        long dist[] = new long[n];
        Arrays.fill(dist , INF);
        dist[0] = 0;
        for(int u : topo) {
            if(dist[u] == INF)
            continue;
            if(u != 0 && u != n - 1 && !online[u])
            continue;
            for(int edge[] : graph[u]) {
                int v = edge[0];
                int w = edge[1];
                if(w < limit)
                continue;
                if(v != 0 && v != n - 1 && !online[v])
                continue;
                if(dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }
        return dist[n - 1] <= k;
    }
}
            