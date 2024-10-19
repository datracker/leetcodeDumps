class Solution {
    public char findKthBit(int n, int k) {
        // Base case: S1 is "0"
        if (n == 1) {
            return '0';
        }
        
        // Calculate the length of Sn: 2^n - 1
        int length = (1 << n) - 1;
        int mid = length / 2 + 1;  // The middle bit is at position (length / 2) + 1

        if (k == mid) {
            return '1';  // The middle bit is always '1'
        } else if (k < mid) {
            return findKthBit(n - 1, k);  // The first half is the same as S_{n-1}
        } else {
            // The second half is the reverse and inverse of S_{n-1}
            // Find the corresponding position in S_{n-1}
            int mirroredIndex = length - k + 1;
            char mirroredBit = findKthBit(n - 1, mirroredIndex);
            // Invert the mirrored bit
            return mirroredBit == '0' ? '1' : '0';
        }
    }
}