class Solution {
    public int numSteps(String s) {
       int steps = 0;
        int n = s.length();
        int carry = 0;

        // Iterate from the least significant bit to the most significant bit
        for (int i = n - 1; i > 0; i--) {
            if ((s.charAt(i) - '0' + carry) % 2 == 0) {
                // If even, just shift right
                steps++;
            } else {
                // If odd, add one (carry over)
                carry = 1;
                steps += 2; // one for addition and one for shifting
            }
        }

        // Add final step if there is a carry left
        return steps + carry;
    }
}