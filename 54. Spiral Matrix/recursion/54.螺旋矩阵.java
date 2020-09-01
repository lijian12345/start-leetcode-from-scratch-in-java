/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0)
            return res;
        int rowStart = 0, colStart = 0, rowEnd = matrix.length - 1, colEnd = matrix[0].length - 1;
        helper(res, matrix, rowStart, rowEnd, colStart, colEnd);
        return res;
    }

    private void helper(List<Integer> res, int[][] matrix, int rowStart, int rowEnd, int colStart,
            int colEnd) {
        if (rowStart > rowEnd || colStart > colEnd) {
            return;
        }
        // rowStart这一行
        for (int i = colStart; i <= colEnd; i++) {
            res.add(matrix[rowStart][i]);
        }
        // colEnd这一列
        for (int i = rowStart + 1; i <= rowEnd; i++) {
            res.add(matrix[i][colEnd]);
        }
        for (int i = colEnd - 1; i >= colStart && rowStart != rowEnd; i--) {
            res.add(matrix[rowEnd][i]);
        }
        for (int i = rowEnd - 1; i >= rowStart + 1 && colStart != colEnd; i--) {
            res.add(matrix[i][colStart]);
        }
        helper(res, matrix, rowStart + 1, rowEnd - 1, colStart + 1, colEnd - 1);
    }
}
// @lc code=end

