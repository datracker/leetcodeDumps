class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[52];
        for (char c : s.toCharArray()) {
            if (c >= 'A' && c <= 'Z') freq[c - 'A' + 26]++;
            else freq[c - 'a']++;
        }

        int count = 0;
        boolean isOdd = false;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] % 2 == 0) {
                count += freq[i];
            }
            else {
                count += freq[i] - 1;
                isOdd = true;
            }
        }

        if (isOdd) count++;
        
        return count;
    }
}