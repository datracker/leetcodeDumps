class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stk = new Stack<>();
        int count = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stk.push(c);
            }
            else {
                if (!stk.isEmpty() && stk.peek() == '(') {
                    stk.pop();
                }
                else {
                    count++;
                }
            }
        }

        count += stk.size();
        return count;
    }
}