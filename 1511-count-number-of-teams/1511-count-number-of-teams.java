class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int count = 0;     
        for (int i = 1; i < n-1; i++) {
            int smallLeft = 0;
            int bigRight = 0;
            
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) smallLeft += 1;
            }
            for (int j = i+1; j < n; j++) {
                if (rating[j] > rating[i]) bigRight += 1;
            }
            
            count += (smallLeft * bigRight);
            
            int bigLeft = i - smallLeft;
            int smallRight = n - 1 - i - bigRight;
            
            count += (bigLeft * smallRight);
        }

        return count;
    }
}