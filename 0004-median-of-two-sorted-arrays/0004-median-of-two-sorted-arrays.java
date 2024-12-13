class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int n = nums1.length; 
        int m = nums2.length;

        int merged[] = new int[n+m];

        for(int i=0; i<nums1.length; i++){
            merged[i] = nums1[i];
        }

        int j = nums1.length;
        for(int i=0; i<nums2.length; i++){
            merged[j] = nums2[i];
            j++;
        }

        Arrays.sort(merged);
        double median;

        if(merged.length%2==0){
            median = (double) (merged[(merged.length/2-1)] + merged[merged.length/2])/2.0;
        }else{
            median = merged[merged.length/2];
        }

        return median;

    }
}