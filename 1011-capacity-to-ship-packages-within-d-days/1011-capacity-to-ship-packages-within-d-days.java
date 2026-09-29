class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int minCapacity = 0, maxCapacity = 0;

        for(int i=0; i<weights.length; i++) {
            minCapacity = Math.max(minCapacity, weights[i]);
            maxCapacity += weights[i];
        }

        while(minCapacity < maxCapacity) {
            int mid = minCapacity + (maxCapacity - minCapacity)/2;
            
            int sum = 0;
            int d = 1;   // minimum 1 day

            for(int w: weights) {
                if(sum + w > mid) {
                    d++;
                    sum = 0;   //reset for the future packages
                }
                sum += w;
            }

            if(d > days) {
                minCapacity = mid + 1;
            } else maxCapacity = mid;
        }
        return minCapacity;
    }
}