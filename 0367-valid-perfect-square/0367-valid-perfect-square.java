class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 1) return false;

        int start = 1, end = num;

        while (start <= end) {
            int mid = start + (end - start) / 2; // Avoid potential overflow

            if ((long) mid * mid == num) {
                return true;
            } else if ((long) mid * mid < num) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }
}
