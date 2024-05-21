class Solution {
    public int arraySign(int[] nums) {
        boolean sign = true;
        for (int num : nums) {
            if (num == 0) return 0;
            sign ^= (num < 0);
        }

        return sign ? 1 : -1;
    }
}