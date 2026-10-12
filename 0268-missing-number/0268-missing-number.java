class Solution {
    public int missingNumber(int[] nums) {
        int ans1= 0, ans2=0;
        for(int i=0; i<=nums.length; i++) {
            ans1 ^= i;
        }
        
        for(int i=0; i<nums.length; i++) {
            ans2 ^= nums[i];
        }
        return ans1 ^ ans2;
    }
}