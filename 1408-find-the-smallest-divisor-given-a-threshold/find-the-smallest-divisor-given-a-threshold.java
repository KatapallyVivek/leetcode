class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 0;

        for(int num : nums){
            high = Math.max(high, num);
        }

        int ans = 0;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(isPossible(nums, threshold, mid)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean isPossible(int[] nums, int threshold, int divisor){
        int sum = 0;
        for(int num : nums){
            sum += (num + divisor - 1) / divisor;
        }

        return sum <= threshold;
    }
}