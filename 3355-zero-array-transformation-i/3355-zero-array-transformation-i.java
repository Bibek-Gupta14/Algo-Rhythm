class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        //concept - create a diff array of nums.length + 1, iterate the query and assign start++ and end+1--
        // do sum += diff[i] and if sum >= nums[i], then true

        int n = nums.length;
        int diff[] = new int[n + 1];

        for (int[] q : queries) {
            int start = q[0];
            int end = q[1];

            diff[start]++;
            diff[end + 1]--;
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += diff[i];
            if (sum < nums[i]) {
                return false;
            }
        }
        return true;
    }
}