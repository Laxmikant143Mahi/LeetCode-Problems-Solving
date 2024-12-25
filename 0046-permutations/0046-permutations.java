class Solution {

    public void findPermutations(int[] nums, int idx, List<List<Integer>> ans){

        // Base case: if idx reaches the length of nums, add the permutation to the answer
        if(idx == nums.length){
            // Convert the array to a list and add it to ans
            ans.add(Arrays.asList(Arrays.stream(nums).boxed().toArray(Integer[]::new)));
            return;
        }

        // Swap each element from idx to the end of the array
        for(int i = idx; i < nums.length; i++){
            // Swap nums[idx] and nums[i]
            int temp = nums[idx];
            nums[idx] = nums[i];
            nums[i] = temp;

            // Recursively call to permute the rest of the elements
            findPermutations(nums, idx + 1, ans);

            // Backtrack: Undo the swap
            temp = nums[idx];
            nums[idx] = nums[i];
            nums[i] = temp;
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        findPermutations(nums, 0, ans);
        return ans;
    }
}
