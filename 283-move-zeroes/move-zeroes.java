class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0;
        for(int right = 0; right < nums.length; right++) {
            if(nums[right] != 0) {
                if(nums[left] != nums[right]) {
                    nums[left] = nums[right];
                    nums[right] = 0;
                }
                left++;
            }
        }
    }
}