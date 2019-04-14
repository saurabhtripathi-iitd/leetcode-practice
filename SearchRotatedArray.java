class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        
        if (len == 0) {
            return -1;
        }
        
        int pivot = findPivot(nums, 0, len - 1);
        
        if (pivot == -1) {
            return binarySearch(nums, 0, len - 1, target);
        }
        
        if (target == nums[pivot]) {
            return pivot;
        }
        
        if (target >= nums[0]) {
            return binarySearch(nums, 0, pivot, target);
        } else {
            return binarySearch(nums, pivot + 1, len - 1, target);
        }
    }
    
    private int binarySearch(int[] nums, int lo, int hi, int target) {
        if (lo > hi) {
            return -1;
        }
        
        int mid;
        
        while (lo <= hi) {
            mid = (lo + hi)/2;
            
            if (nums[mid] == target) {
                return mid;
            }
            
            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        return -1;
    }
    
    private int findPivot(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return -1;
        }
        
        if (lo == hi) {
            return lo;
        }
        
        int mid;
        
        while (lo <= hi) {
            mid = (lo + hi)/2;
            
            if (mid < hi && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            
            if (mid > lo && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }
            
            if (nums[mid] <= nums[0]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        
        return -1;
    }
}