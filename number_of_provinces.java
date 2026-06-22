class Solution {
    public int findCircleNum(int[][] isConnected){
        int n = isConnected.length,cnt = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0 ; i < n ; i++){
            if(!visited[i]){
                bfs(isConnected,visited,i);
                cnt++;
            }
        }
        return cnt;
    }
    private void bfs(int[][]isConnected,boolean[] visited,int st){
        int n = isConnected.length;
        Queue<Integer> q = new LinkedList<>();
        q.offer(st);
        visited[st] = true;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int i = 0  ; i < n ; i++){
                if(!visited[i] && isConnected[node][i] == 1){
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}