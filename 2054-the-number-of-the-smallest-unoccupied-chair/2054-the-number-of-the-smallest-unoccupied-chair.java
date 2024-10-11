class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        Map<int[], Integer> idxMap = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            idxMap.put(times[i], i);
        }

        Arrays.sort(times, (a, b) -> Integer.compare(a[0], b[0]));
        int[] chairs = new int[times.length];

        for (int[] time : times) {
            for (int i = 0; i < chairs.length; i++) {
                if (chairs[i] <= time[0]) {
                    chairs[i] = time[1];
                    if (idxMap.get(time) == targetFriend) {
                        return i;
                    }
                    break;
                }
            }
        }
        
        return -1;
    }
}