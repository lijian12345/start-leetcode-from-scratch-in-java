class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int newLen = 0;
        int preNum = nums[newLen];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != preNum) {
                nums[++newLen] = nums[i];
                preNum = nums[i];
            }
        }
        return newLen + 1;
    }
}