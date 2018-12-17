class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0], tempSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (tempSum < 0) {
                if (tempSum > maxSum)
                    maxSum = tempSum;
                tempSum = 0;
            } else if (tempSum > maxSum) {
                maxSum = tempSum;
            }
            tempSum += nums[i];
        }
        if (tempSum > maxSum) {
            maxSum = tempSum;
        }
        return maxSum;
    }
}