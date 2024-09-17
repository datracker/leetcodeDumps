class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : s1.split(" ")) {
            map.put(word, map.getOrDefault(word, 0)+1);
        }

        for (String word : s2.split(" ")) {
            map.put(word, map.getOrDefault(word, 0)+1);
        }

        List<String> res = new ArrayList<>();
        for (String key : map.keySet()) {
            if (map.get(key) == 1) {
                res.add(key);
            }
        }

        return res.toArray(new String[0]);
    }
}