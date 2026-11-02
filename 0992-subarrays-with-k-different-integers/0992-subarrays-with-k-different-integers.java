class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k-1);
    }

    public int helper(int nums[], int k) {
        int count = 0;
        int left = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            while(map.size() > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                
                if(map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            count += i - left + 1;
        }
        return count;
    }
}