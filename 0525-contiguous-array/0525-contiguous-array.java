class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> prefixDiffCount = new HashMap<>();

        int maxLen = 0;
        int diff = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                diff++;
            }
            else {
                diff--;
            }

            if (diff == 0) {
                maxLen = i+1;
            }
            else {
                if (prefixDiffCount.containsKey(diff)) {
                    int left = prefixDiffCount.get(diff);
                    maxLen = Math.max(i - left, maxLen);
                }
                else {
                    prefixDiffCount.put(diff, i);
                }
            }
        }

        return maxLen;
    }
}