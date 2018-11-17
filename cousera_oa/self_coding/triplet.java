class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int result = 0;
        
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            //if (nums[i] > target) {
            //    break;
            //}
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] < target - nums[i]) {
                    result += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }  
        return result;
    }
}