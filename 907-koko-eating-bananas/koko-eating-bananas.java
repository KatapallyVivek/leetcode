class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;

        for(int pile : piles) {
            high = Math.max(pile , high);
        }

        while(low <= high) {
            int mid = low + (high - low) / 2;
            int k = mid;
            long hrs = 0;

            for(int pile : piles){
                hrs += (pile + k - 1) / k;
            }
            if(hrs <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}