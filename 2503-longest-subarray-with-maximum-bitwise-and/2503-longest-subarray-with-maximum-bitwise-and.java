class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int curr_len = 0;
        int max_len = 0;
        for (int num : nums) {
            if (num == max) {
                curr_len += 1;
                max_len = Math.max(curr_len, max_len);
            }
            else {
                curr_len = 0;
            }
        }

        return max_len;
    }
}