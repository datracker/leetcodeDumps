class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<int[]> stk = new Stack<>();

        for (int i = 0; i <= heights.length; i++) {
            int currHeight = (i == heights.length) ? 0 : heights[i];
            while (!stk.isEmpty() && stk.peek()[0] > currHeight) {
                int[] popped = stk.pop();
                int width = stk.isEmpty() ? i : i - stk.peek()[1] - 1;
                maxArea = Math.max(maxArea, popped[0] * width);
            }
            stk.push(new int[] {currHeight, i});
        }

        return maxArea;
    }
}