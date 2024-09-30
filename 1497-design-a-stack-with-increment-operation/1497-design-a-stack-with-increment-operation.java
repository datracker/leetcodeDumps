class CustomStack {
    int[] data;
    int topIdx = 0;

    public CustomStack(int maxSize) {
        data = new int[maxSize];
    }
    
    public void push(int x) {
        if (topIdx >= data.length) {
            return;
        }
        data[topIdx] = x;
        topIdx++;
    }
    
    public int pop() {
        if (topIdx == 0) {
            return -1;
        }
        topIdx--;
        return data[topIdx];        
    }
    
    public void increment(int k, int val) {
        for (int i = 0; i < data.length && i < k; i++) {
            data[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */