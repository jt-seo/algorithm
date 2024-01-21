// 73. Set Matrix Zeroes

// 다른 저장공간을 사용할 수 없으므로
// 첫번째 행과 열에 zero 가 있는지를 별도의 boolean 변수에 저장해 놓고
// 나머지 셀의 0 정보를 첫번째 행과 열에 기록한 후 0 채우기.

// Solved
// Medium
// Topics
// Companies
// Hint
// Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstRowZero = false;
        boolean firstColZero = false;
        int m = matrix.length;
        int n = matrix[0].length;
        
        // 첫 번째 열에 0이 있는지 확인
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }
        
        // 첫 번째 행에 0이 있는지 확인
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }
        
        // 나머지 행렬에 대해 0의 위치를 첫 번째 행과 열에 표시
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        // 첫 번째 열의 표시를 사용하여 행 업데이트
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // 첫 번째 행의 표시를 사용하여 열 업데이트
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // 첫 번째 행 업데이트
        if (firstRowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        
        // 첫 번째 열 업데이트
        if (firstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
