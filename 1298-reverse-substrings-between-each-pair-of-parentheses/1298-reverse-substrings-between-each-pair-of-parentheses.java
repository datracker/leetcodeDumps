class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> stk = new Stack();
        Queue<Character> q = new LinkedList<>();

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ')') {
                while (!stk.isEmpty() && stk.peek() != '(') {
                    q.offer(stk.pop());
                }
                if (!stk.isEmpty() && stk.peek() == '(') {
                    stk.pop();
                }
                while (!q.isEmpty()) {
                    stk.push(q.poll());
                }
            }
            else {
                stk.push(c);
            }
        }

        while (!stk.isEmpty()) {
            sb.append(stk.pop());
        }
        return sb.reverse().toString();
    }
}