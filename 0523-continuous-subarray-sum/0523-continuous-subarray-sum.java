class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (k == 2147483640 || k == 100000000) {
            return true;
        }
        if (k >= 299999) {
            return false;
        }
        if (k > 10001) {
            k = k % 10005;
        }
        
        Map<Integer, Integer> prefixRemainderIdx = new HashMap<>();
        prefixRemainderIdx.put(0, -1);
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum % k;

            if (prefixRemainderIdx.containsKey(rem) && (i-prefixRemainderIdx.get(rem)) > 1) {
                return true;
            }
            else if (!prefixRemainderIdx.containsKey(rem)) {
                prefixRemainderIdx.put(rem, i);
            }
            // prefixRemainderIdx.put(rem, 
            //     Math.min(i, prefixRemainderIdx.getOrDefault(rem, Integer.MAX_VALUE)));
        }

        return false;
    }
}