class NumArray {

    ArrayList<Integer> pref;

    public NumArray(int[] nums) {
        
        pref = new ArrayList<>();
        pref.add(nums[0]);

        for(int i = 1; i < nums.length; i++){
            pref.add(pref.get(i-1) + nums[i]);
        }
    }
    
    public int sumRange(int left, int right) {
        
        if (left == 0) {
            return pref.get(right);
        } else {
            return pref.get(right) - pref.get(left - 1);
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */