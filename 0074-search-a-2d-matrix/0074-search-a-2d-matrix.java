class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int validrow = -1;
        int top = 0, bottom = m - 1;
        while (top <= bottom) {
            int mid = top + (bottom - top) / 2;
            if(target >= matrix[mid][0] && target <= matrix[mid][n-1]) {        // case for mid
                validrow = mid;
                break;
            }
            else if(matrix[mid][0] > target) {   // check if the 1st value of new row = last value of prev column
                bottom = mid - 1;
            } else top = mid + 1;
        }

        if(validrow == - 1) return false;    //valid not found

        int left = 0, right = n - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(matrix[validrow][mid] == target) {
                return true;
            } else if(matrix[validrow][mid] > target) {
                right = mid - 1;
            } else left = mid + 1;
        }
        return false;
    }
}


// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         int n = matrix.length, m = matrix[0].length;
//         int left = 0, right = n * m - 1;
//         while (left <= right) {
//             int mid = left + (right - left) / 2;
//             int row = mid / m;
//             int col = mid % m;
//             if (matrix[row][col] == target)
//                 return true;
//             else if (matrix[row][col] < target)
//                 left = mid + 1;
//             else
//                 right = mid - 1;
//         }
//         return false;
//     }
// }