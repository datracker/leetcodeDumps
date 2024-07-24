class Solution {

    public int[] sortJumbled(int[] mapping, int[] nums) {
        int[][] tempArr = new int[nums.length][2];
        int idx = 0;

        for (int i = 0; i < nums.length; i++) {
            int convertedNum = convert(nums[i], mapping);
            tempArr[idx++] = new int[] {convertedNum, i};
        }

        Arrays.sort(tempArr, (a, b) -> {
            if (a == b) return a[1] - b[1];
            return a[0] - b[0];
        });

        int[] res = new int[nums.length];
        idx = 0;
        for (int i = 0; i < nums.length; i++) {
            res[idx++] = nums[tempArr[i][1]];
        }

        return res;
    }

    int convert(int num, int[] map) {
        int newNum = 0;
        int mult = 1;
        
        do {
            newNum += (map[num % 10] * mult);
            num /= 10;
            mult *= 10;
        } while (num > 0);

        return newNum;
    }
}