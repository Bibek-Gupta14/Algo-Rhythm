class Solution {
    public int maxProduct(int[] nums) {
        int prefix = 1, suffix = 1;
        int max = -10;      // constraint says range is [-10,10]

        for(int i=0; i<nums.length; i++) {
            // check if prefix and suffix are 0 or not
            if(prefix == 0) prefix = 1;
            if(suffix == 0) suffix = 1;

            prefix *= nums[i];   // from start to end L -> R
            suffix *= nums[nums.length - i - 1];  // from back to front R -> L

            max = Math.max(max, Math.max(prefix, suffix));
        }
        return max;
    }
}