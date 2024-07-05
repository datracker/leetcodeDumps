class Solution {
    public String longestDiverseString(int a, int b, int c) {
        //priority queue impl
        //a = 1, b = 2, c = 3
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(y[0], x[0]));

        if (a > 0) pq.offer(new int[] {a, 0});
        if (b > 0) pq.offer(new int[] {b, 1});
        if (c > 0) pq.offer(new int[] {c, 2});

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            int[] toAdd = pq.poll();
            char c1 = (char) (toAdd[1] + 'a');
            int n = sb.length();

            if (n >= 2 && sb.charAt(n-1) == c1 && sb.charAt(n-2) == c1) {
                if (!pq.isEmpty()) {
                    int[] toAdd2 = pq.poll();
                    char c2 = (char) (toAdd2[1] + 'a');
                    sb.append(c2);
                    toAdd2[0]--;
                    if (toAdd2[0] > 0) {
                        pq.offer(toAdd2);
                    }
                    pq.offer(toAdd);
                }                
            }
            else {
                sb.append(c1);
                toAdd[0]--;
                if (toAdd[0] > 0) {
                    pq.offer(toAdd);
                }
            }
        }

        return sb.toString();
    }
}