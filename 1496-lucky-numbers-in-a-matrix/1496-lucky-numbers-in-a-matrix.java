class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length;
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int minIdx = findMinIdx(matrix[i]);
            for (int j = 0; j < m; j++) {
                if (matrix[i][minIdx] < matrix[j][minIdx]) {
                    break;
                }
                else if (j == m-1 && matrix[i][minIdx] >= matrix[j][minIdx]) {
                    res.add(matrix[i][minIdx]);
                }
            }
        }

        return res;
    }

    int findMinIdx(int[] arr) {
        int minIdx = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[minIdx]) {
                minIdx = i;
            }
        }

        return minIdx;
    }
}