public int numSubarrayProductLessThanK(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
        return 0;
    }
    if (k <= 1) {
        return 0;
    }
    
    int left = 0, product = 1, res = 0;
    for (int i = 0; i < nums.length; i++) {
        product *= nums[i];
        while (product >= k) {
            product /= nums[left];
            left++;
        }
        res += i - left + 1;
    }
    return res;
}