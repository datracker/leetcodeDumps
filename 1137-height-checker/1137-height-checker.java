class Solution {
    public int heightChecker(int[] heights) {
        int[] freq = new int[101];
        for (int i = 0; i < heights.length; i++) {
            freq[heights[i]]++;
        }

        int count = 0;
        int start = 0;
        for (int i = 1; i < 101; i++) { 
            int countShouldBe = freq[i];
            while (countShouldBe > 0) {
                if (heights[start++] != i) {
                    count++;
                }
                countShouldBe--;
            }                    
        }

        return count;
    }
}