class Solution {
    public int searchInsert(int[] nums, int target) {
        int index = 0;
        int len = nums.length;
        if (nums[len - 1] < target) {
            return len;
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] >= target) {
                index = i;
                break;
            }
        }
        return index;
    }
}