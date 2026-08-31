class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long required = (long) m * k;

        if (required > bloomDay.length) {
            return -1;
        }

        int low = 1;
        int high = 0;

        for (int d : bloomDay) {
            high = Math.max(high, d);
        }

        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canMake(bloomDay, m, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean canMake(int[] bloomDay, int m, int k, int day) {
        int bouquets = 0;
        int flowers = 0;

        for (int d: bloomDay) {
            if (d <= day) {
                flowers++;

                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }

                if (bouquets == m) {
                    return true;
                }
            } else {
                flowers = 0;
            }
        }

        return false;
    }
}