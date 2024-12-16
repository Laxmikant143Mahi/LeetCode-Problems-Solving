

class Solution {
    public int[] findErrorNums(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int duplicate = -1, missing = -1;
        int n = nums.length;

        // Count the frequency of each number in the array
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Check the numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            if (map.containsKey(i)) {
                if (map.get(i) == 2) {
                    duplicate = i; // This number is duplicated
                }
            } else {
                missing = i; // This number is missing
            }
        }

        return new int[]{duplicate, missing};
    }
}
