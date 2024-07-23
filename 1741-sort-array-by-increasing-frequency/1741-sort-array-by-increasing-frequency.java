class Solution {
    public int[] frequencySort(int[] nums) {
        int[] freq = new int[201];
        int count = 0;
        for (int num : nums) {
            if (freq[num+100] == 0) {
                count++;
            }
            freq[num+100]++;
        }

        int[][] lis = new int[count][2];
        int idx = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                lis[idx++] = new int[]{i-100, freq[i]};
            }
        }

        Arrays.sort(lis, (a, b) -> {
            if (a[1] == b[1]) return b[0] - a[0];
            else return a[1] - b[1];
        });

        int[] res = new int[nums.length];
        idx = 0;
        for (int[] pair : lis) {
            for (int i = 0; i < pair[1]; i++) {
                res[idx++] = pair[0];
            }
        }

        return res;
    }
}