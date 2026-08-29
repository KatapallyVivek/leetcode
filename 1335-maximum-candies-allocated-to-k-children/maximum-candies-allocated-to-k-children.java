class Solution {
    public int maximumCandies(int[] candies, long k) {
        int low = 1;
        int high = 0;
        int maxCandies = 0;

        for(int pile : candies) {
            high = Math.max(pile, high);
        }

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(isPossible(candies, k, mid)) {
                maxCandies = mid;
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return maxCandies;
    }

    private boolean isPossible(int[] candies, long k, int mid) {
        long possibleChildren = 0;

        for(int pile : candies) {
            possibleChildren += pile / mid;

            if(possibleChildren >= k) {
                return true;
            }
        }
        return false;
    }
}