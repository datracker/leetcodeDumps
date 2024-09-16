class Solution {
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < timePoints.size()-1; i++) {
            String nexTime = timePoints.get(i+1);
            String currTime = timePoints.get(i);
            int diff = getDiffInMinutes(currTime, nexTime);
            minDiff = Math.min(minDiff, diff);
        }

        int hour = Integer.parseInt(timePoints.get(0).substring(0, 2));
        hour += 24;
        String nexTime = "" + hour + timePoints.get(0).substring(2);
        String currTime = timePoints.get(timePoints.size()-1);
        int diff = getDiffInMinutes(currTime, nexTime);
        minDiff = Math.min(minDiff, diff);


        return minDiff;

    }

    int getDiffInMinutes(String currTime, String nexTime) {
        int diff = 0;
        int currHour = Integer.parseInt(currTime.substring(0, 2));
        int nexHour = Integer.parseInt(nexTime.substring(0, 2));
        int currMin = Integer.parseInt(currTime.substring(3));
        int nexMin = Integer.parseInt(nexTime.substring(3));

        if (nexMin < currMin) {
            nexMin += 60;
            nexHour -= 1;
        }

        diff += nexMin - currMin;
        diff += ((nexHour - currHour) * 60);

        return diff;
    }
}