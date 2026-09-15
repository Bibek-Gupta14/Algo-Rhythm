class Solution {
    public int findMaxLength(int[] nums) {
        int sum = 0, max = 0;
        int count = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 1)? 1: -1;
            if (map.containsKey(sum)) {
                max = Math.max(max, i - map.get(sum));      // stores ('current index' - 'last index when same scenario')
            } else {
                map.put(sum, i);        // stores the (sum, index)
            }
        }
        return max;
    }
}