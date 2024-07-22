class Solution {

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public String[] sortPeople(String[] names, int[] heights) {
        for (int t = 0; t < names.length; t++) {
            for (int i = 0; i < names.length-1; i++) {
                if (heights[i] < heights[i+1]) {
                    swap(heights, i, i+1);
                    swap(names, i, i+1);
                }
            }
        }

        return names;
    }
}