// Brute Force Approach (Using Arrays)

// Iterate through every cell in the 9×9 board.
// Check if the number appears more than once in:
// The same row (using an array of size 9).
// The same column (using another array of size 9).
// The same 3×3 sub-box (using a third array of size 9).
// If any rule is violated, return false.

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(board, i) || !isValidColumn(board, i) || !isValidBox(board, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidRow(char[][] board, int row) {
        boolean[] seen = new boolean[9];
        for (int j = 0; j < 9; j++) {
            if (board[row][j] != '.') {
                int num = board[row][j] - '1'; 
                if (seen[num]) return false;
                seen[num] = true;
            }
        }
        return true;
    }

    private boolean isValidColumn(char[][] board, int col) {
        boolean[] seen = new boolean[9];
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.') {
                int num = board[i][col] - '1';
                if (seen[num]) return false;
                seen[num] = true;
            }
        }
        return true;
    }

    private boolean isValidBox(char[][] board, int boxIndex) {
        boolean[] seen = new boolean[9];
        int rowStart = (boxIndex / 3) * 3, colStart = (boxIndex % 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char cell = board[rowStart + i][colStart + j];
                if (cell != '.') {
                    int num = cell - '1';
                    if (seen[num]) return false;
                    seen[num] = true;
                }
            }
        }
        return true;
    }
}

// Better Approach (Using HashSets)

// Approach:
// Use three HashSets:
// rows[i] stores numbers in row i.
// cols[j] stores numbers in column j.
// boxes[k] stores numbers in 3×3 sub-box k(where k=(i/3)×3+(j/3)).
// Check each number once while iterating, ensuring no duplicates exist.

  import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num == '.') continue;

                int boxIndex = (i / 3) * 3 + (j / 3);
                if (rows[i].contains(num) || cols[j].contains(num) || boxes[boxIndex].contains(num)) {
                    return false;
                }

                rows[i].add(num);
                cols[j].add(num);
                boxes[boxIndex].add(num);
            }
        }

        return true;
    }
}

// Best Approach (Using Arrays for O(1) Space Efficiency)
// Approach:
// Instead of HashSets, use boolean arrays (rows[9][9], cols[9][9], boxes[9][9]).
// Each cell in these arrays represents whether a number (1-9) has already appeared in that row, column, or box.

class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;

                int num = board[i][j] - '1';
                int boxIndex = (i / 3) * 3 + (j / 3);

                if (rows[i][num] || cols[j][num] || boxes[boxIndex][num]) {
                    return false;
                }

                rows[i][num] = true;
                cols[j][num] = true;
                boxes[boxIndex][num] = true;
            }
        }

        return true;
    }
}

