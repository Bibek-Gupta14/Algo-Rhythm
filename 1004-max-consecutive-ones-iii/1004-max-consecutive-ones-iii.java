class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, zero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zero++;
            }

            //exceeding the k
            if (zero > k) {
                if (nums[left] == 0) {
                    zero--;
                }
                left++;
            }
        }

        return nums.length-left;
    }
}