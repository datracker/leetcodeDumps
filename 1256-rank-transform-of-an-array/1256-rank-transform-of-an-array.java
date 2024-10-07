class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Queue<Integer> pq = new PriorityQueue<>();
        Map<Integer, List<Integer>> idMap = new HashMap<>();
        
        for (int i = 0; i < arr.length; i++) {
            if (!idMap.containsKey(arr[i])) {
                idMap.put(arr[i], new ArrayList<>());
                pq.offer(arr[i]);
            }
            idMap.get(arr[i]).add(i);
        }

        int[] res = new int[arr.length];
        int rank = 1;
        while (!pq.isEmpty()) {
            int num = pq.poll();
            List<Integer> indices = idMap.get(num);
            for (int index : indices) {                
                res[index] = rank;                
            }
            rank++;
        }

        return res;
    }
}