class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int left = 0;
        int total_satisfied = 0;
        int window = 0;
        int max_window = 0;
        for (int right = 0; right < customers.length; right++) {
            if (grumpy[right] == 0) {
                total_satisfied += customers[right];
            }
            else {
                window += customers[right];
            }
            if (right - left + 1 > minutes) {
                if (grumpy[left] == 1) {
                    window -= customers[left];
                }
                left++;
                
            }   
            max_window = Math.max(max_window, window);         
        }

        return total_satisfied + max_window;
    }
}