/*
 * @lc app=leetcode.cn id=240 lang=java
 *
 * [240] 搜索二维矩阵 II
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        return searchMatrixHelper(matrix, 0, 0, matrix[0].length - 1, matrix.length - 1,
                matrix[0].length - 1, matrix.length - 1, target);
    }

    private boolean searchMatrixHelper(int[][] matrix, int x1, int y1, int x2, int y2, int xMax,
            int yMax, int target) {
        //只需要判断左上角坐标即可
        if (x1 > xMax || y1 > yMax) {
            return false;
        }

        //x 轴代表的是列，y 轴代表的是行
        if (x1 == x2 && y1 == y2) {
            return matrix[y1][x1] == target;
        }
        int m1 = (x1 + x2) >>> 1;
        int m2 = (y1 + y2) >>> 1;
        if (matrix[m2][m1] == target) {
            return true;
        }
        if (matrix[m2][m1] < target) {
            // 右上矩阵
            return searchMatrixHelper(matrix, m1 + 1, y1, x2, m2, x2, y2, target) ||
            // 左下矩阵
                    searchMatrixHelper(matrix, x1, m2 + 1, m1, y2, x2, y2, target) ||
                    // 右下矩阵
                    searchMatrixHelper(matrix, m1 + 1, m2 + 1, x2, y2, x2, y2, target);

        } else {
            // 右上矩阵
            return searchMatrixHelper(matrix, m1 + 1, y1, x2, m2, x2, y2, target) ||
            // 左下矩阵
                    searchMatrixHelper(matrix, x1, m2 + 1, m1, y2, x2, y2, target) ||
                    // 左上矩阵
                    searchMatrixHelper(matrix, x1, y1, m1, m2, x2, y2, target);
        }
    }
}
// @lc code=end

