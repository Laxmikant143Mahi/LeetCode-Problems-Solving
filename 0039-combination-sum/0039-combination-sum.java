import java.util.*;

class Solution {
    public void findCombination(List<List<Integer>> ans, List<Integer> combination, int[] candidates, int idx, int target) {
        // Base case: if target is zero, add the combination to the result
        if (target == 0) {
            ans.add(new ArrayList<>(combination));
            return;
        }

        // Termination case: if target becomes negative or we exceed the array bounds
        if (target < 0 || idx >= candidates.length) {
            return;
        }

        // Include the current candidate
        combination.add(candidates[idx]);
        findCombination(ans, combination, candidates, idx, target - candidates[idx]);

        // Backtrack and exclude the current candidate
        combination.remove(combination.size() - 1);

        // Move to the next candidate
        findCombination(ans, combination, candidates, idx + 1, target);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        findCombination(ans, combination, candidates, 0, target);
        return ans;
    }
}
