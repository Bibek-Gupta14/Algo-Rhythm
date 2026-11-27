class Solution {

    public void dfs(int node, int[][] graph, List<Integer> currentpath, List<List<Integer>> ans) {
        if(node == graph.length - 1) {
            //this is the target(end) node
            ans.add(new ArrayList<Integer>(currentpath));            
        }

        //go to the neighbor of the current node
        for(int neighbor: graph[node]) {
            currentpath.add(neighbor);

            dfs(neighbor, graph, currentpath, ans);

            currentpath.remove(currentpath.size() - 1);   //backtrack and remove the last elem from path
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currentpath = new ArrayList<>();
        currentpath.add(0);
        dfs(0, graph, currentpath, ans);
        return ans;
    }
}