class KthLargest {
    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>(k);
        for (int num : nums) {
            if (pq.size() < k) {
                pq.offer(num);
            }
            else {
                if (num > pq.peek()) {
                    pq.poll();
                    pq.offer(num);
                }
            }
        }
    }
    
    public int add(int val) {
        if (pq.size() < k) {
            pq.offer(val);
        }
        else {
            if (val > pq.peek()) {
                pq.poll();
                pq.offer(val);
            }
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 2, 3, 4, 4, 5, 5, 8, 9, 10
 3 -> 4
 5 -> 5
 10 -> 5
 9 -> 8
 4 -> 8
 */