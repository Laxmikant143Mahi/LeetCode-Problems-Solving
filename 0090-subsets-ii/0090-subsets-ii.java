class Solution {

    public void getAllSubsets(int nums[], int i, List<Integer> ans, List<List<Integer>> finalAns) {
        if (i == nums.length) {
            finalAns.add(new ArrayList<>(ans)); // Add a copy of the current list
            return;
        }

        // Include the current element
        ans.add(nums[i]);
        getAllSubsets(nums, i + 1, ans, finalAns);
        ans.remove(ans.size() - 1); // Remove the last element (backtrack)

        // Exclude the current element

        int idx = i+1;

        while(idx<nums.length && nums[idx]==nums[idx-1]){
            idx++;
        }

        getAllSubsets(nums, idx , ans, finalAns);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> finalAns = new ArrayList<>();
        getAllSubsets(nums, 0, ans, finalAns);
        return finalAns;
    }
}