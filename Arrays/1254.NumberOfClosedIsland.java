class Solution {
    public int closedIsland(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;

        for (int r = 0; r < rows; r++) {
            sink(grid, r, 0);
            sink(grid, r, cols - 1);
        }
        for (int c = 0; c < cols; c++) {
            sink(grid, 0, c);
            sink(grid, rows - 1, c);
        }

        int count = 0;
        for (int r = 1; r < rows - 1; r++) {
            for (int c = 1; c < cols - 1; c++) {
                if (grid[r][c] == 0) {
                    sink(grid, r, c);
                    count++;
                }
            }
        }
        return count;
    }

    private void sink(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 1) {
            return;
        }
        grid[r][c] = 1;
        sink(grid, r + 1, c);
        sink(grid, r - 1, c);
        sink(grid, r, c + 1);
        sink(grid, r, c - 1);
    }
}