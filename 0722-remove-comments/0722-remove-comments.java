class Solution {
    public List<String> removeComments(String[] source) {
        List<String> result = new ArrayList<>();
        boolean inBlockComment = false;
        StringBuilder newLine = new StringBuilder();

        for (String line : source) {
            int i = 0;
            if (!inBlockComment) newLine.setLength(0);
            
            while (i < line.length()) {
                if (!inBlockComment && i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '*') {
                    inBlockComment = true;
                    i += 2;
                } else if (inBlockComment && i + 1 < line.length() && line.charAt(i) == '*' && line.charAt(i + 1) == '/') {
                    inBlockComment = false;
                    i += 2;
                } else if (!inBlockComment && i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '/') {
                    break; // Ignore the rest of the line
                } else if (!inBlockComment) {
                    newLine.append(line.charAt(i));
                    i++;
                } else {
                    i++;
                }
            }
            
            if (!inBlockComment && newLine.length() > 0) {
                result.add(newLine.toString());
            }
        }
        
        return result;
    }
}