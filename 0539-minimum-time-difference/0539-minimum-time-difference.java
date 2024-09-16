class Solution {
    public int findMinDifference(List<String> timePoints) {
        final int TOTAL_MINS = 24 * 60;
        if (timePoints.size() >= TOTAL_MINS) {
            return 0;
        }

        boolean[] seen = new boolean[TOTAL_MINS];
        for (String time : timePoints) {
            int min = convertToMin(time);
            if (seen[min]) {
                return 0;
            }
            else {
                seen[min] = true;
            }
        }

        int first = Integer.MAX_VALUE, prev = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;
        
        for (int i = 0; i < 1440; i++) {
            if (seen[i]) {
                if (first == Integer.MAX_VALUE) {
                    first = i;
                } else {
                    minDiff = Math.min(minDiff, i - prev);
                }
                prev = i;
            }
        }
        

        minDiff = Math.min(minDiff, 1440 - prev + first);

        return minDiff;
    }

    int convertToMin(String time) {
        int mins = 0;
        mins += ((time.charAt(0) - '0') * 10);
        mins += (time.charAt(1) - '0');
        mins *= 60;
        mins += ((time.charAt(3) - '0') * 10);
        mins += (time.charAt(4) - '0');

        return mins;
    }
}