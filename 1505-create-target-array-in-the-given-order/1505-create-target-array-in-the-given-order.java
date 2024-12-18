class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> target = new ArrayList<>();

        // Insert elements into the target list
        for (int i = 0; i < nums.length; i++) {
            target.add(index[i], nums[i]); // Insert at the specified index
        }

        // Convert the list back to an array
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = target.get(i);
        }

        return result;
    }
}
