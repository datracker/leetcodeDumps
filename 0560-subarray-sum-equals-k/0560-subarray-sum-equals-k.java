class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        Map<Integer,Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); //there will always be a prefix subarray whose sum is 0

        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (prefixSumCount.containsKey(sum - k)) {
                count += prefixSumCount.get(sum - k);
            }
            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}