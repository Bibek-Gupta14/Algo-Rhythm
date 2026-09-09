class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long max = 0;
        long currentSum = 0;
        Set<Integer> windowSet = new HashSet<>();
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            int currentVal = nums[right];

            // 1. If duplicate found, shrink window from the left until duplicate is removed
            while (windowSet.contains(currentVal)) {
                windowSet.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }

            // 2. Add the new element to the window
            windowSet.add(currentVal);
            currentSum += currentVal;

            // 3. Check if window size is exactly k
            if (right - left + 1 == k) {
                // Update maximum sum found so far
                max = Math.max(max, currentSum);
                windowSet.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }
        }

        return max;
    }
}