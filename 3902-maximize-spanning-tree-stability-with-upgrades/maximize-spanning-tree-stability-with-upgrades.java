// Maximize Spanning Tree Stability with Upgrades
class Solution {
    int[] parent;

    int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    boolean union(int a,int b){
        int pa = find(a);
        int pb = find(b);
        if(pa == pb){
            return false;
        }
        parent[pa] = pb;
        return true;
    }

    boolean possible(int n,int[][] edges,int k,int target){

        parent = new int[n];
        for(int i = 0 ; i < n ; i++){
            parent[i] = i;
        }

        int count = 0;
        int upgrades = 0;

        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            int s = e[2];
            int must = e[3];

            if(must == 1){
                if(s < target){
                    return false;
                }
                if(!union(u,v)){
                    return false;
                }
                count++;
            }
        }

        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            int s = e[2];
            int must = e[3];

            if(must == 0 && s >= target && find(u) != find(v)){
                union(u,v);
                count++;
            }
        }

        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            int s = e[2];
            int must = e[3];

            if(must == 0 && s < target && s*2 >= target && find(u) != find(v) && upgrades < k){
                upgrades++;
                union(u,v);
                count++;
            }
        }

        return count == n-1;
    }

    public int maxStability(int n, int[][] edges, int k) {

        int left = 0;
        int right = 0;

        for(int[] e : edges){
            right = Math.max(right,e[2]*2);
        }

        int ans = -1;

        while(left <= right){

            int mid = (left + right) / 2;

            if(possible(n,edges,k,mid)){
                ans = mid;
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }

        return ans;
    }
}