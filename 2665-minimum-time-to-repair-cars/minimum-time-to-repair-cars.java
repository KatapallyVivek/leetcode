class Solution {
    public long repairCars(int[] ranks, int cars) {

        long low = 1;
        long high = (long) ranks[0] * cars * cars;

        int minRank = ranks[0];
        for (int rank : ranks) {
            minRank = Math.min(minRank, rank);
        }

        high = (long) minRank * cars * cars;

        while (low <= high) {

            long mid = low + (high - low) / 2;

            if (canRepair(ranks, cars, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean canRepair(int[] ranks, int cars, long time) {

        long repaired = 0;

        for (int rank : ranks) {

            long n = (long) Math.sqrt(time / rank);

            repaired += n;

            if (repaired >= cars) {
                return true;
            }
        }

        return false;
    }
}