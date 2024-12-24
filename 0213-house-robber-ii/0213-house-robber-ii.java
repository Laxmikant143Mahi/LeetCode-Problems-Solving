class Solution {
    int solve(ArrayList<Integer> list) {
        int n = list.size();

        if (n == 0) return 0; // No houses to rob
        if (n == 1) return list.get(0); // Only one house to rob

        int dp[] = new int[n];

        dp[0] = list.get(0);
        dp[1] = Math.max(list.get(0), list.get(1));

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(list.get(i) + dp[i - 2], dp[i - 1]);
        }

        return dp[n - 1];
    }

    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0]; // Only one house
        if (n == 0) return 0; // No houses

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i != 0) {
                list1.add(nums[i]);
            }

            if (i != n - 1) {
                list2.add(nums[i]);
            }
        }

        return Math.max(solve(list1), solve(list2));
    }
}
