class Solution {
    boolean[] visited;
    int count = 0;
    List<List<Integer>> list;
    int n;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        n = rooms.size();
        visited = new boolean[n];
        list = rooms;
        dfs(0);
        return count == n;
    }
    void dfs(int v) {
        if(visited[v] == true) return;
        visited[v] = true;
        count++;
        if(count == n) return;
        for(int node : list.get(v)) {
            dfs(node);
        }
    }
}