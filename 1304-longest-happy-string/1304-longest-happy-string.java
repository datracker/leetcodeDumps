class Solution {
    class Pair {
        char ch;
        int count;
    
        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> y.count - x.count);
        if (a > 0) pq.add(new Pair('a', a));
        if (b > 0) pq.add(new Pair('b', b));
        if (c > 0) pq.add(new Pair('c', c));
        
        StringBuilder result = new StringBuilder();
        
        while (!pq.isEmpty()) {
            Pair first = pq.poll();
            
            if (result.length() >= 2 && result.charAt(result.length() - 1) == first.ch && result.charAt(result.length() - 2) == first.ch) {
                if (pq.isEmpty()) break; // No other character to use, can't continue
                
                Pair second = pq.poll();
                result.append(second.ch);
                second.count--;
                
                if (second.count > 0) pq.add(second);
                pq.add(first); // Put first back for future consideration
            } else {
                result.append(first.ch);
                first.count--;
                
                if (first.count > 0) pq.add(first);
            }
        }
        
        return result.toString();
    }
}