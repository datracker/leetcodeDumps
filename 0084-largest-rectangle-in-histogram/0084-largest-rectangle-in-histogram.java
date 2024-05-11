class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;

        Stack<int[]> stk = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            if (stk.isEmpty()) {
                stk.push(new int[] {heights[i], i});
            }
            else {
                int[] valueIndexPair = stk.peek();
                if (valueIndexPair[0] <= heights[i]) {
                    stk.push(new int[] {heights[i], i});
                }
                else {
                    while (!stk.isEmpty() && valueIndexPair[0] > heights[i]) {
                        //can not extend the rectangle anymore
                        valueIndexPair = stk.pop();
                        int left = -1;
                        if (!stk.isEmpty()) {
                            left = stk.peek()[1];
                        }
                        int area = (i - left - 1) * valueIndexPair[0];
                        maxArea = Math.max(maxArea, area);
                        if (!stk.isEmpty()) {
                            valueIndexPair = stk.peek();
                        }
                    }
                    stk.push(new int[] {heights[i], i});
                }
            }
        }

        while (!stk.isEmpty()) {
            int[] valueIndexPair = stk.pop();
            int left = -1;
            if (!stk.isEmpty()) {
                left = stk.peek()[1];
            }
            int area = (heights.length - left - 1) * valueIndexPair[0];
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}