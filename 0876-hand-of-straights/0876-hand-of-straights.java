class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        Arrays.sort(hand);

        for (int i = 0; i < hand.length; i++) {
            if (hand[i] == -1) continue;
            
            int currCard = hand[i];
            hand[i] = -1;
            int count = groupSize - 1;

            if (count > 0) {
                for (int j = i+1; j < hand.length; j++) {
                    if (hand[j] == currCard+1) {
                        currCard = hand[j];
                        hand[j] = -1;
                        count--;                        
                    }

                    if (count == 0) {
                        break;
                    }
                }
            }

            if (count > 0) {
                return false;
            }            
        }

        for (int card : hand) {
            if (card != -1) {
                return false;
            }
        }

        return true;
    }
}