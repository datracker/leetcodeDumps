class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0) return new int[0];
        
        // Create a sorted version of the unique values
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        
        // Create a map to store the rank of each unique value
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        for (int num : sortedArr) {
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank++);
            }
        }
        
        // Build the result array using the rank map
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = rankMap.get(arr[i]);
        }
        
        return res;
    }

}