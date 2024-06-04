class Solution {
    public int appendCharacters(String s, String t) {
        if(s.equals(t)) return 0;
        int i = 0, j = 0;
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        int m = sChar.length;
        int n = tChar.length;

        for (; i < m; i++) {
            if (sChar[i] == tChar[j]) {
                j++;
            }
            if (j == n) {
                return 0;
            }
        }

        return n - j;
    }
}