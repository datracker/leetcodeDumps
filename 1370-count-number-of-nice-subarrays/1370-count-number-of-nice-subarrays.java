class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        List<Integer> oddIdx = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] %2 != 0) {
                oddIdx.add(i);
            }
        }

        int n2 = oddIdx.size();
        if (n2 < k) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i <= n2 - k; i++) {
            int start = (i == 0) ? oddIdx.get(i) + 1 : oddIdx.get(i) - oddIdx.get(i - 1);
            int end = (i + k == n2) ? nums.length - oddIdx.get(i + k - 1) : oddIdx.get(i + k) - oddIdx.get(i + k - 1);
            count += start * end;
        }

        return count;
    }
}