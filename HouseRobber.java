class Solution {
    public int rob(int[] nums) {
        int max = 0, len = nums.length;
        int[] aux = new int[len];
        
        if (len == 0)
            return 0;
        if (len == 1)
            return nums[0];
        if (len == 2) {
            return (nums[0] > nums[1] ? nums[0] : nums[1]);
        }
        
        aux[0] = nums[0];
        aux[1] = nums[1];
        aux[2] = nums[2] + nums[0];
        
        if (aux[0] > aux[1]) {
            if (aux[0] > aux[2])
                max = aux[0];
            else
                max = aux[2];
        } else {
            if (aux[1] > aux[2])
                max = aux[1];
            else
                max = aux[2];
        }
        
        for (int i = 3;i < nums.length;i++) {
            aux[i] = (aux[i - 2] > aux[i - 3] ? nums[i] + aux[i - 2] : nums[i] + aux[i - 3]);
            
            if (max < aux[i]) {
                max = aux[i];
            }
        }
        
        return max;
    }
}