class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if (len == 0) {
            return res;
        }
        
        permuteUtil(nums, 0, len, res);
        
        return res;
    }
    
    private void permuteUtil(int[] nums, int l, int r, List<List<Integer>> res) {
        if (l == r) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0;i < r;i++) {
                temp.add(nums[i]);
            }
            
            res.add(temp);
            return;
        }
        
        for (int i = l; i < r;i++) {
            swap(nums, i, l);
            permuteUtil(nums, l + 1, r, res);
            swap(nums, i, l);
        }
    }
    
    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}