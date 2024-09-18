class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] numArr = new String[n];
        for (int i = 0; i < n; i++) {
            numArr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numArr, (a, b) -> (b+a).compareTo(a+b));

        // If, after being sorted, the largest number is `0`, the entire number
        // is zero.
        if (numArr[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(numArr[i]);
        }

        return sb.toString();
    }
}