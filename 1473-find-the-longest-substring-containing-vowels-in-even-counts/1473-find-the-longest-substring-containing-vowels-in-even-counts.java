class Solution {
    public int findTheLongestSubstring(String s) {
        int[] states = new int[32];
        Arrays.fill(states, -2); // Initialize with -2 to distinguish from valid indices
        states[0] = -1;

        int longestLen = 0;
        int curr_state = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                curr_state ^= (1 << 0);
            }
            else if (c == 'e') {
                curr_state ^= (1 << 1);
            }
            else if (c == 'i') {
                curr_state ^= (1 << 2);
            }
            else if (c == 'o') {
                curr_state ^= (1 << 3);
            }
            else if (c == 'u') {
                curr_state ^= (1 << 4);
            }     

            if (states[curr_state] >= -1) {
                longestLen = Math.max(longestLen, i - states[curr_state]);
            } else {
                states[curr_state] = i;
            }
        }

        return longestLen;        
    }
}