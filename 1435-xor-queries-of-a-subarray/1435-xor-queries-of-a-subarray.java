class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] prefixXOR = new int[arr.length];
        prefixXOR[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixXOR[i] = prefixXOR[i-1] ^ arr[i];
        }

        int[] res = new int[queries.length];
        int idx = 0;
        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];
            if (left == 0) {
                res[idx] = prefixXOR[right];
            }
            else {
                res[idx] = prefixXOR[left-1] ^ prefixXOR[right];
            }
            idx++;
        }

        return res;
    }
}