class Solution {
    public int convertTime(String current, String correct) {
        // Parse hours and minutes for both times
        String[] arr1 = current.split(":");
        String[] arr2 = correct.split(":");

        int currHour = Integer.parseInt(arr1[0]);
        int currMin = Integer.parseInt(arr1[1]);

        int corrHour = Integer.parseInt(arr2[0]);
        int corrMin = Integer.parseInt(arr2[1]);

        // Convert both times to total minutes since midnight
        int currTotalMinutes = currHour * 60 + currMin;
        int corrTotalMinutes = corrHour * 60 + corrMin;

        // Calculate the difference in minutes
        int difference = corrTotalMinutes - currTotalMinutes;

        // Use a greedy approach to minimize operations
        int count = 0;
        int[] operations = {60, 15, 5, 1}; // Possible time adjustments

        for (int op : operations) {
            count += difference / op; // Add the number of operations for this step
            difference %= op; // Update the remaining difference
        }

        return count;
    }
}
