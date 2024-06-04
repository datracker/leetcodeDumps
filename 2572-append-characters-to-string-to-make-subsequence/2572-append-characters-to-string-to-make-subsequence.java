class Solution {
    public int appendCharacters(String s, String t) {
        if(s.equals(t)) return 0;
        int lastIdx = 0;
        int startIdx = 0;
        while (lastIdx < t.length()) {
            while (startIdx < s.length() && s.charAt(startIdx) != t.charAt(lastIdx)) {
                startIdx++;
            }
            if (startIdx == s.length()) break;
            startIdx++;
            lastIdx++;            
        }

        return t.length() - lastIdx;
    }
}