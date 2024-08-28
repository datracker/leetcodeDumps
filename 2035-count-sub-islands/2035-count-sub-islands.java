class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;

        int m = grid2.length, n = grid2[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    boolean isCountable = dfs(grid1, grid2, i, j);
                    if (isCountable) {
                        count++;
                    }
                }
            }
        }

        return count;
    }


    boolean dfs(int[][] grid1, int[][] grid2, int i, int j) {
        if (i < 0 || i >= grid2.length || j < 0 || j >= grid2[0].length || grid2[i][j] != 1) {
            return true;
        }

        if (grid1[i][j] == 0) {
            return false;
        }

        grid2[i][j] = 2;


        // don't return early coz you are not visiting all cells
        // //up
        // if (i-1 >= 0 && grid2[i-1][j] == 1) {
        //     if (!dfs(grid1, grid2, i-1, j)) {
        //         return false;
        //     }
        // }

        // //right
        // if (j+1 < grid2[0].length && grid2[i][j+1] == 1) {
        //     if (!dfs(grid1, grid2, i, j+1)) {
        //         return false;
        //     }
        // }

        // //down
        // if (i+1 < grid2.length && grid2[i+1][j] == 1) {
        //     if (!dfs(grid1, grid2, i+1, j)) {
        //         return false;
        //     }
        // }

        // //left
        // if (j-1 >= 0 && grid2[i][j-1] == 1) {
        //     if (!dfs(grid1, grid2, i, j-1)) {
        //         return false;
        //     }
        // }

        boolean up = dfs(grid1, grid2, i-1, j);
        boolean right = dfs(grid1, grid2, i, j+1);
        boolean down = dfs(grid1, grid2, i+1, j);
        boolean left = dfs(grid1, grid2, i, j-1);

        return up && right && down && left;
    }
}