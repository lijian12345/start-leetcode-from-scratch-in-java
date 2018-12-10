class Solution {
    public int searchInsert(int[] nums, int target) {
        int index = 0;
        int len = nums.length;
        // 下句中len直接用nums.length的话会慢很多（存疑）
        while (index < len && nums[index] < target) {
            index++;
        }
        return index;
    }
}
