class Solution {
    int count = 0;
    public int beautifulSubsets(int[] nums, int k) {
        List<Integer> subArray = new ArrayList<>();
        backtrack(nums, k, 0, subArray);
        return count;
    }

    void backtrack(int[] nums, int k, int start, List<Integer> subArr) {
        if (start == nums.length) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            int num = nums[i];
            if (canGo(subArr, num, k)) {
                subArr.add(num);
                count++;
                backtrack(nums, k, i+1, subArr);
                subArr.remove(subArr.size()-1);
            }
        }
    }

    boolean canGo(List<Integer> arr, int num, int k) {
        if (arr.size() == 0) return true;
        for (int elem : arr) {
            if (Math.abs(elem - num) == k) {
                return false;
            }
        }

        return true;
    }
}