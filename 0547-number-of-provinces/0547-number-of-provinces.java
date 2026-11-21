class Solution {
    void dfs(int node, boolean visited[], int isConnected[][]) {
        
        // STEP 1 - toggle visited -> true
        visited[node] = true;
        
        // STEP 2 - go through each neigh(i)
        for(int i = 0; i < isConnected.length; i++) {
            
            // STEP 3 - if neigh(i) not visited (visited = False), dfs again
            if(isConnected[node][i] == 1 && !visited[i]) {
                dfs(i, visited, isConnected);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int count = 0;

        boolean visited[] = new boolean[isConnected.length];
        
        for(int i=0; i<isConnected.length; i++) {

            if(!visited[i]) {
                dfs(i, visited, isConnected);
                count++;
            }
        }
        return count;
    }
}