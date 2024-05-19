class Solution {
    public int numSteps(String s) {
        int steps = 0;
        while (s.length() > 1) {
            if (isEven(s)) {
                s = rightShift(s);
            }
            else {
                s = addOne(s);
            }
            steps++;
        }

        return steps;
    }

    boolean isEven(String s) {
        return s.charAt(s.length()-1) == '0';
    }

    String rightShift(String s) {
        return s.substring(0, s.length()-1);
    }

    String addOne(String s) {
        StringBuilder sb = new StringBuilder();

        int carry = 1;
        for (int i = s.length()-1; i >= 0; i--) {
            int a = s.charAt(i) - '0';
            int sum = a ^ carry;
            carry = a & carry;

            sb.append(sum);
        }
        if (carry == 1) sb.append(carry);

        return sb.reverse().toString();
    }
}