class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new int[]{v, w});
        }

        int[][] dist = new int[n][k + 1];
        for(int i = 0; i< n;i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        dist[0][1] = 0;
        pq.offer(new int[]{0,0,1});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int d = curr[0];
            int u = curr[1];
            int count = curr[2];

            if(u == n - 1){
                return d;
            }
            if(d>dist[u][count]){
                continue;
            }

            for(int[] neigbhor : adj.get(u)){
                int v = neigbhor[0];
                int weight = neigbhor[1];

                int nextCount = (labels.charAt(v) == labels.charAt(u)) ? count + 1 : 1;

                if(nextCount <= k){
                    if(d + weight < dist[v][nextCount]){
                        dist[v][nextCount] = d + weight;
                        pq.offer(new int[]{dist[v][nextCount], v, nextCount});
                    }
                }
            }
        }
        return -1;
    }
}