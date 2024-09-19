class Solution {
   public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();
        
        // Try every operator in the expression
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            
            if (c == '+' || c == '-' || c == '*') {
                // Split the expression into two parts
                String leftPart = expression.substring(0, i);
                String rightPart = expression.substring(i + 1);
                
                // Recursively calculate results for both parts
                List<Integer> leftResults = diffWaysToCompute(leftPart);
                List<Integer> rightResults = diffWaysToCompute(rightPart);
                
                // Combine results from both sides using the operator
                for (int left : leftResults) {
                    for (int right : rightResults) {
                        int computedResult = 0;
                        if (c == '+') {
                            computedResult = left + right;
                        } else if (c == '-') {
                            computedResult = left - right;
                        } else if (c == '*') {
                            computedResult = left * right;
                        }
                        result.add(computedResult);
                    }
                }
            }
        }
        
        // If the expression is a single number, return it as a result
        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }
        
        return result;
    }
}