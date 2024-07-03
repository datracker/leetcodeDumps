class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if (n <= 4) {
            return 0;
        }

        Arrays.sort(nums);
        int diff = nums[n-1] - nums[3];
        diff = Math.min(diff, nums[n-2] - nums[2]);
        diff = Math.min(diff, nums[n-3] - nums[1]);
        diff = Math.min(diff, nums[n-4] - nums[0]);
        
        return diff;
    }
}