class Solution {
    public double averageWaitingTime(int[][] customers) {
        int start = 0;
        int finish = 0;
        long totalWait = 0;
        
        for (int[] customer : customers) {
            start = Math.max(start, customer[0]);
            finish = start + customer[1];
            totalWait +=  (finish - customer[0]);
            start = finish;            
        }

        return (double) totalWait / customers.length;
    }
}