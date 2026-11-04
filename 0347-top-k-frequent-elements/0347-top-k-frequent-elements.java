class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        //create a map to store the freq of elements
        Map<Integer, Integer> map = new HashMap<>();

        for(int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // create min heap (as they want 'top' k elem)
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));

        // i'll traverse over the keys in the map
        for(int n: map.keySet()) {
            if(pq.size() < k) {
                //add the elem to pq
                pq.add(n);
            }
            else if(map.get(n) > map.get(pq.peek())) {
                pq.poll();
                pq.add(n);
            } 
        }

        int ans[] = new int[k];
        for(int i=0; i<k; i++) {
            ans[i] = pq.poll();
        }
        return ans;
    }
}