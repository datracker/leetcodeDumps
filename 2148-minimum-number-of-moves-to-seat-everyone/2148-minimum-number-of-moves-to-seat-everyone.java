class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        
        int n = seats.length;
        int dist = 0;
        for (int i = 0; i < n; i++) {
            dist += Math.abs(seats[i] - students[i]);
        }

        return dist;
    }
}