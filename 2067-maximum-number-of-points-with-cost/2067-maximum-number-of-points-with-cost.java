class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;

        long[] last = new long[n];
        for (int j = 0; j < n; j++) {
            last[j] = points[m-1][j];
        }

        for(int i = m-2; i >= 0; i--) {
            long[] temp = new long[n];
            for (int j = 0; j < n; j++) {
                long max = 0;
                for (int k = 0; k < n; k++) {
                    max = Math.max(max, points[i][j] + last[k] - Math.abs(j-k));
                }
                temp[j] = max;
            }
            for (int j = 0; j < n; j++) {
                last[j] = temp[j];
            }
        }

        long max = 0;
        for (int j = 0; j < n; j++) {
            max = Math.max(max, last[j]);
        }

        return max;
    }
}