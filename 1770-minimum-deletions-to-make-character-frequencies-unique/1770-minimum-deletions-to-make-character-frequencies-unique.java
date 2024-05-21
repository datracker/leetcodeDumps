class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int delCount = 0;
        Set<Integer> nums = new HashSet<>();
        for (int count : freq) {
            while (nums.contains(count) && count > 0) {
                count--;
                delCount++;
            }
            if (count > 0) {
                nums.add(count);
            }
        }

        return delCount;
    }
}