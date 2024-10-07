class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] rem = new int[k];
        int n = arr.length;
        
        // Count remainders
        for (int i = 0; i < n; i++) {
            int mod = (arr[i] % k + k) % k;  // Make sure the remainder is always positive
            rem[mod]++;
        }
        
        // Check if the count of numbers with remainder 0 is even
        if (rem[0] % 2 != 0) {
            return false;
        }
        
        // Check if the count of remainder i matches the count of remainder k-i
        for (int i = 1; i <= k / 2; i++) {
            if (i != k - i && rem[i] != rem[k - i]) {
                return false;
            }
        }
        
        // Special case for k/2 when k is even
        if (k % 2 == 0 && rem[k / 2] % 2 != 0) {
            return false;
        }
        
        return true;
}

}