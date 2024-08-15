class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] notes = new int[2];
        for (int bill : bills) {
            if (bill == 5) {
                notes[0]++;
            }
            else if (bill == 10) {
                notes[1]++;
                notes[0]--;
            }
            else {
                if (notes[1] > 0) {
                    notes[1]--;
                    notes[0]--;
                }
                else {
                    notes[0]--;
                    notes[0]--;
                    notes[0]--;
                }
            }

            if (notes[0] < 0 || notes[1] < 0) {
                return false;
            }
        }
        return true;
    }
}