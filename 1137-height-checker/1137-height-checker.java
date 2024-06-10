class Solution {
    public int heightChecker(int[] heights) {
        int[] current = Arrays.copyOf(heights, heights.length);
        Arrays.sort(heights);

        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (current[i] != heights[i]) {
                count++;
            }
        }

        return count;
    }
}