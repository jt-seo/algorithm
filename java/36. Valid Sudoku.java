// 36. Valid Sudoku
// Medium
// Topics
// Companies
// Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

// Each row must contain the digits 1-9 without repetition.
// Each column must contain the digits 1-9 without repetition.
// Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
// Note:

// A Sudoku board (partially filled) could be valid but is not necessarily solvable.
// Only the filled cells need to be validated according to the mentioned rules.

import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Create hash sets for rows, columns, and sub-boxes
        HashSet<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char currentVal = board[i][j];

                if (currentVal != '.') {
                    // Check if the currentVal has already been seen in the same row, column, or sub-box
                    if (!seen.add(currentVal + " in row " + i) ||
                        !seen.add(currentVal + " in column " + j) ||
                        !seen.add(currentVal + " in sub-box " + i/3 + "-" + j/3)) {
                        // If any of the add operations return false, it means there's a repetition
                        return false;
                    }
                }
            }
        }

        // If no repetitions were found, the board is valid
        return true;
    }
}
