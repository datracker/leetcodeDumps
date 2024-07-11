class Solution {
    int i = 0;
    public String reverseParentheses(String s) {        
        return helper(s.toCharArray());
    }

    private String helper(char[] cArr) {
        StringBuilder sb = new StringBuilder();
        while (i < cArr.length) {
            if (cArr[i] == '(') {
                i++;
                sb.append(helper(cArr));
            }
            else if (cArr[i] == ')') {                
                i++;
                return sb.reverse().toString();
            }
            else {
                sb.append(cArr[i]);
                i++;
            }
        }

        return sb.toString();
    }
}