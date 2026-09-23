class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int small[] = (nums1.length > nums2.length) ? nums2 : nums1;
        int larger[] = (nums1.length > nums2.length) ? nums1 : nums2;

        int totalLength = (nums1.length + nums2.length);
        int low = 0, high = small.length;

        while (low <= high) {
            int partX = (low + high) / 2;
            int partY = ((totalLength + 1) / 2) - partX;

            int l1 = (partX == 0) ? Integer.MIN_VALUE : small[partX - 1];
            int r1 = (partX == small.length) ? Integer.MAX_VALUE : small[partX];

            int l2 = (partY == 0) ? Integer.MIN_VALUE : larger[partY - 1];
            int r2 = (partY == larger.length) ? Integer.MAX_VALUE : larger[partY];

            if (l1 <= r2 && l2 <= r1) {
                //even case
                if (totalLength % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    //odd case
                    return Math.max(l1, l2);
                }

            }
            else if (l1 > r2)
                high = partX - 1;
            else
                low = partX + 1;
        }
        return 0;
    }
}