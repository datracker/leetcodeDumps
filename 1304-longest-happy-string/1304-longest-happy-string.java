class Solution {
    public String longestDiverseString(int a, int b, int c) {
        int n = a+b+c;
        int ca = 0, cb = 0, cc = 0;
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (ca == 2) {
                if (b > c) {
                    sb.append('b');
                    b--;
                    cb++;
                    ca = 0;
                }
                else if (c > 0) {
                    sb.append('c');
                    c--;
                    cc++;
                    ca = 0;
                }
            }
            else if (cb == 2) {
                if (a > c) {
                    sb.append('a');
                    a--;
                    ca++;
                    cb = 0;
                }
                else if (c > 0) {
                    sb.append('c');
                    c--;
                    cc++;
                    cb = 0;
                }                
            }
            else if (cc == 2) {
                if (b > a) {
                    sb.append('b');
                    b--;
                    cb++;
                    cc = 0;
                }
                else if (a > 0) {
                    sb.append('a');
                    a--;
                    ca++;
                    cc = 0;
                }                
            }
            else {
                if (a > 0 && a >= b && a >= c) {
                    sb.append('a');
                    a--;
                    ca++;
                }
                else if (b > 0 && b >= a && b >= c) {
                    sb.append('b');
                    b--;
                    cb++;
                }
                else if (c > 0) {
                    sb.append('c');
                    c--;
                    cc++;
                }
            }
        }

        return sb.toString();
    }
}