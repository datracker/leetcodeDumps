class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");
        Set<String> dict = new HashSet<>(dictionary);
        Map<String, String> cache = new HashMap<>();

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (cache.containsKey(word)) {
                sb.append(cache.get(word));
            }
            else {
                String root = getRoot(word, dict);
                if (!root.isEmpty()) {
                    cache.put(word, root);
                    sb.append(root);
                }
                else {
                    sb.append(word);
                }
            }
            sb.append(" ");
        }

        sb.setLength(sb.length() - 1);

        return sb.toString();
    }

    private String getRoot(String word, Set<String> dict) {
        for (int i = 1; i < word.length(); i++) {
            String root = word.substring(0, i);
            if (dict.contains(root)) {
                return root;
            }
        }

        return "";
    }
}