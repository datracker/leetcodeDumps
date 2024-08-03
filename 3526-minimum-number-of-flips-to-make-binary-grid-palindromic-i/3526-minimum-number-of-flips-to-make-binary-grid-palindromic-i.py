class Solution:
    def minFlips(self, grid: List[List[int]]) -> int:        
        row_edits = 0
        col_edits = 0
        for row in grid:
            for i in range(len(row)//2):
                if row[i] != row[len(row)-1-i]:
                    row_edits += 1
        
        for j in range(len(grid[0])):
            for i in range(len(grid) // 2):
                if grid[i][j] != grid[len(grid)-1-i][j]:
                    col_edits += 1
        
        return min(row_edits, col_edits)

        