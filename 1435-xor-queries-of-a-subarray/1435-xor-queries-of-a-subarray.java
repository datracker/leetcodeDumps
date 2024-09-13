class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] res = new int[queries.length];
        int idx = 0;
        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];
            int ans = arr[start];
            
            for (int i = start+1; i <= end; i++) {
                ans ^= arr[i];
            }

            res[idx] = ans;
            idx++;
        }

        return res;
    }
}