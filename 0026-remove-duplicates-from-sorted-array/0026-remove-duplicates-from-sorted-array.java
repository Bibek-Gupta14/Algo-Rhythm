class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 0;
        for(int i=1; i<nums.length; i++) {
            //unique elem
            if(nums[left] != nums[i]) {
                left++;     // increase the counter
                nums[left] = nums[i];  //replace the position
            }
        }
        return left+1;
    }
}