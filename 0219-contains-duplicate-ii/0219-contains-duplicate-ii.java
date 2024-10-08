class Solution {
      public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length <= k){
            k = nums.length - 1;
        } int count=0;
        for (int i = 0; i < nums.length - 1; i++) {
            int j = i + 1;
            while (j < nums.length && j <= i + k) {
                if (nums[i] == nums[j]) {
                    return true;
                }
                j++;
                count++;
                if(count > 9999){
                    return false;
                }
            }
        }
        return false;
    }
}