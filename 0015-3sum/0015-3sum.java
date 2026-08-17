class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //edge cases
        if(nums.length < 3) return new ArrayList<>();
        
        //sort the array
        Arrays.sort(nums);
        HashSet<List<Integer>> result = new HashSet<>();        // to uniquely store the triplet

        for (int i = 0; i < nums.length-2; i++) {
            int left = i + 1;
            int right = nums.length-1;

            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0) {
                    result.add(Arrays.asList(nums[i],nums[left],nums[right])); 
                }

                if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return new ArrayList<>(result);
    }
}