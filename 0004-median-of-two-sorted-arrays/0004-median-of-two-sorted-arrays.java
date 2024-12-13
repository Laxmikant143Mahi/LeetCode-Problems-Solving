class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n = nums1.length;
        int m = nums2.length;
        int low = 0, high = n;

        while (low <= high) {
            int partition1 = (low + high) / 2;
            int partition2 = (n + m + 1) / 2 - partition1;

            int nums1LeftMax = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int nums1RightMin = (partition1 == n) ? Integer.MAX_VALUE : nums1[partition1];

            int nums2LeftMax = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int nums2RightMin = (partition2 == m) ? Integer.MAX_VALUE : nums2[partition2];

            if (nums1LeftMax <= nums2RightMin && nums2LeftMax <= nums1RightMin) {
                // Correct partition found
                if ((n + m) % 2 == 0) {
                    return (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin)) / 2.0;
                } else {
                    return Math.max(nums1LeftMax, nums2LeftMax);
                }
            } else if (nums1LeftMax > nums2RightMin) {
                // Move left in nums1
                high = partition1 - 1;
            } else {
                // Move right in nums1
                low = partition1 + 1;
            }
        }
        return 0;
        
    }
}
