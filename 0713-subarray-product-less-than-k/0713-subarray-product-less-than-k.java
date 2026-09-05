class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0, left = 0, product = 1;

        if (k <= 1)
            return 0;

        for (int right = 0; right < nums.length; right++) {
            product = product * nums[right];

            //incorrect condition
            while (product >= k) {
                product /= nums[left];
                left++;
            }

            count = count + (right - left + 1); // count++ is incorrect
        }

        return count;
    }
}