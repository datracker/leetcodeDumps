class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);
        
        int sum = 0;
        for (int num : nums) {
            sum += num;

            int prevSumNeeded = sum % k;
            if (prevSumNeeded < 0) {
                prevSumNeeded += k;
            }

            if (prefixSumCount.containsKey(prevSumNeeded)) {
                count += prefixSumCount.get(prevSumNeeded);
            }

            prefixSumCount.put(prevSumNeeded, prefixSumCount.getOrDefault(prevSumNeeded, 0) + 1);
        }

        return count;
    }
}