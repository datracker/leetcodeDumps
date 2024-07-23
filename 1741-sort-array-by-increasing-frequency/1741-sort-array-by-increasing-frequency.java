class Solution {
    public int[] frequencySort(int[] nums) {
        int[] freq = new int[201];
        for (int num : nums) {
            freq[num+100]++;
        }

        List<int[]> lis = new ArrayList<>();
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                lis.add(new int[]{i-100, freq[i]});
            }
        }

        Collections.sort(lis, (a, b) -> {
            if (a[1] == b[1]) return b[0] - a[0];
            else return a[1] - b[1];
        });

        int[] res = new int[nums.length];
        int idx = 0;
        for (int[] pair : lis) {
            for (int i = 0; i < pair[1]; i++) {
                res[idx++] = pair[0];
            }
        }

        return res;
    }
}