class Solution {
    public int minimizedMaximum(int n, int[] quantities) {

        int low = 1;
        int high = 0;

        for (int quantity : quantities) {
            high = Math.max(high, quantity);
        }

        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(n, quantities, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean isPossible(int n, int[] quantities, int maxProducts) {

        int storesNeeded = 0;

        for (int q : quantities) {
            storesNeeded += (q + maxProducts - 1) / maxProducts;

            if (storesNeeded > n) {
                return false;
            }
        }
        return true;
    }
}