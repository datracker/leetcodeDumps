class Solution {
    public int appendCharacters(String s, String t) {
        if(s.equals(t)) return 0;
        int i = 0, j = 0;
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        for (; i < sChar.length; i++) {
            if (sChar[i] == tChar[j]) {
                j++;
            }
            if (j == tChar.length) {
                return 0;
            }
        }

        return tChar.length - j;
    }
}