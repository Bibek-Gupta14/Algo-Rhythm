class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ans = 0;
        int i = 0;   // index that tracks the heaters[]

        for(int h: houses) {
            while(i < heaters.length - 1 && Math.abs(heaters[i] - h) >= Math.abs(heaters[i+1] - h)) {
                i++;
            }
            ans = Math.max(ans, Math.abs(heaters[i] - h));
        }
        return ans;
    }
}