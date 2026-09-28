class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1;  //min speed to  eat the banana
        int maxSpeed = 0;

        // find the max time needed to eat all the banana -> Max value in array
        for(int i=0; i<piles.length; i++) {
            maxSpeed = Math.max(piles[i], maxSpeed);
        }

        while(minSpeed < maxSpeed) {
            int mid = minSpeed + (maxSpeed - minSpeed)/2;

            if(Speedcheck(piles, h, mid)) {
                maxSpeed = mid;
            } else minSpeed = mid + 1;
        }
        return minSpeed;    // the left index (sabse chota value)
    }

    public boolean Speedcheck(int arr[], int h, int speed) {
        int minTime = 0;
        for(int i=0; i<arr.length; i++) {
            minTime += (int) Math.ceil((double) arr[i] / speed);
        }
        return minTime <= h;
    }
}