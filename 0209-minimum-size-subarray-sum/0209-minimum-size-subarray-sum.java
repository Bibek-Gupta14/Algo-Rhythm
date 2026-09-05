class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, min = Integer.MAX_VALUE, sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            // for min size length, we write the valid condition in the loop
            while(sum >= target) {
                min = Math.min(min, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        // if there is no valid subarray
        if(min == Integer.MAX_VALUE) {
            return 0;
        }

        return min;
    }
}