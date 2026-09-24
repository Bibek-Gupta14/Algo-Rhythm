class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        int min = 0;
        while(left < right) {
            int mid = left + (right - left)/2;
            if(nums[mid] > nums[right]) {    // [3,0,1,2] -> 2 > 0 , i.e, r > m --> then go to LEFT bcz right is sorted
                left = mid+1;  // [4,5,6,7,0,1,2] -> 2 !> 7 , i.e, m > r --> then go to RIGHT bcz left is sorted
            }
            else {
                right = mid;
            }
        }
        return nums[left];  // left == right
    }
}