import java.util.Arrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] merged = new int[n + m];
        
        // Merge nums1 and nums2 into the merged array
        for (int i = 0; i < nums1.length; i++) {
            merged[i] = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            merged[n + i] = nums2[i];
        }

        // Sort the merged array
        Arrays.sort(merged);

        // Calculate the median
        double median;
        int len = merged.length;
        if (len % 2 == 0) {
            median = (merged[len / 2 - 1] + merged[len / 2]) / 2.0;
        } else {
            median = merged[len / 2];
        }

        return median;
    }
}
