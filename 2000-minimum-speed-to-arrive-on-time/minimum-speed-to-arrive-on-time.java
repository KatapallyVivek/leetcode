class Solution {

    public int minSpeedOnTime(int[] dist, double hour) {

        int low = 1;
        int high = 10_000_000;

        if (dist.length - 1 >= hour) {
            return -1;
        }

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (isPossible(dist, hour, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean isPossible(int[] dist, double hour, int speed) {

        double time = 0;

        for (int i = 0; i < dist.length - 1; i++) {
            time += Math.ceil((double) dist[i] / speed);
        }

        time += (double) dist[dist.length - 1] / speed;

        return time <= hour;
    }
}