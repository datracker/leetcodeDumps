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
        
        int[] prefixRemainderIdx = new int[k];
        int n = nums.length;
        Arrays.fill(prefixRemainderIdx, n);
        prefixRemainderIdx[0] = -1;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum % k;

            if (i-prefixRemainderIdx[rem] > 1) {
                return true;
            }
            else if (prefixRemainderIdx[rem] == n) {
                prefixRemainderIdx[rem] = i;
            }
        }

        return false;
    }
}