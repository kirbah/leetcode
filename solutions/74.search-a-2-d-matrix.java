/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int low = 0;
        int high = rows * cols - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midValue = matrix[mid / cols][mid % cols];

            if (midValue < target) {
                low = mid + 1;
            } else if (midValue > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean searchMatrix_V2(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length - 1;
        int row = 0;
        while (low <= high) {
            row = (low + high) >>> 1;
            if (matrix[row][0] < target) {
                low = row + 1;
            } else if (matrix[row][0] > target) {
                high = row - 1;
            } else {
                return true;
            }
        }

        if (row > 0 && matrix[row][0] > target) {
            row--;
        }

        low = 0;
        high = matrix[0].length - 1;
        while (low <= high) {
            int col = (low + high) >>> 1;
            if (matrix[row][col] < target) {
                low = col + 1;
            } else if (matrix[row][col] > target) {
                high = col - 1;
            } else {
                return true;
            }
        }

        return false;
    }    
}
// @lc code=end

