class Solution {
    public int totalNQueens(int n) {
        return backtrack(0, 0, 0, 0, n);
    }

    private int backtrack(int row, int cols, int diag1, int diag2, int n) {
        if (row == n) {
            return 1;
        }

        int count = 0;
        // Available positions in the current row
        int availablePositions = ((1 << n) - 1) & (~(cols | diag1 | diag2));

        while (availablePositions != 0) {
            // Get the lowest set bit (rightmost position to place a queen)
            int p = availablePositions & -availablePositions;
            // Clear the bit
            availablePositions -= p;

            count += backtrack(row + 1, cols | p, (diag1 | p) << 1, (diag2 | p) >> 1, n);
        }

        return count;
    }
}