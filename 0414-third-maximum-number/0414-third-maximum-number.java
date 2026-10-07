class Solution {
    public int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;

        for (int num : nums) {
            // Skip duplicates
            if (num == first || num == second || num == third) {
                continue;
            }
            if (num > first) {
                // New largest: shift everything down
                third = second;
                second = first;
                first = num;
            } else if (num > second) {
                // New second largest: shift third down
                third = second;
                second = num;
            } else if (num > third) {
                // New third largest
                third = num;
            }
        }

        // If third was never assigned, return the maximum
        return (int) (third == Long.MIN_VALUE ? first : third);
    }
}