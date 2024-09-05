class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = 0;
        for (int roll : rolls) {
            sum += roll;
        }

        int expectedSum = (rolls.length + n) * mean;
        int req = expectedSum - sum;
        if (req > n*6 || req < n) {
            return new int[0];
        }

        int[] res = new int[n];
        int toAdd = req / n;
        int extra = req % n;
        for (int i = 0; i < n; i++) {
            res[i] += toAdd;
        }

        for (int i = 0; i < n && extra > 0; i++) {
            if (res[i] < 6) {
                res[i] += 1;
                extra--;
            }
        }

        return res;
    }
}