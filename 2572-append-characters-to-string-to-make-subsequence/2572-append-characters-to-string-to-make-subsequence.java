class Solution {
    public int appendCharacters(String s, String t) {
        if(s.equals(t)) return 0;
        int lastIdx = 0;
        int startIdx = 0;
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        while (lastIdx < t.length()) {
            while (startIdx < s.length() && sChar[startIdx] != tChar[lastIdx]) {
                startIdx++;
            }
            if (startIdx == s.length()) break;
            startIdx++;
            lastIdx++;            
        }

        return t.length() - lastIdx;
    }
}