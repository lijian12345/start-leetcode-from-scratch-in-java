class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            if (target - numbers[j] < numbers[i]) {
                j--;
            } else if (target - numbers[j] > numbers[i]) {
                i++;
            } else {
                break;
            }
        }
        return new int[] { i + 1, j + 1 };
    }
}