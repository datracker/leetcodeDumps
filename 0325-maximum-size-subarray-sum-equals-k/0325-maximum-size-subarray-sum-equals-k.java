class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if(nums == null || nums.length == 0) { // 1
           return 0;
        }
        Map<Integer, Integer> prefixSum = new HashMap<>();

        int sum = 0;
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                size = Math.max(i+1, size);
                prefixSum.put(sum, i);
            }
            else {
                int subSum = sum-k;
                if (prefixSum.containsKey(subSum)) {
                    size = Math.max(size, i - prefixSum.get(subSum));
                }
                else if (!prefixSum.containsKey(sum)) {
                    prefixSum.put(sum, i);
                }
            }
        }

        return size;
    }
}