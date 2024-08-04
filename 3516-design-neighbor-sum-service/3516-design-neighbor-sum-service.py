class neighborSum:

    def __init__(self, grid: List[List[int]]):
        self.grid = grid
        self.m = len(grid)
        self.n = len(grid[0]) if self.m > 0 else 0
        

    def adjacentSum(self, value: int) -> int:
        for i in range(self.m):
            for j in range(self.n):
                if self.grid[i][j] == value:
                    sum = 0
                    if i-1 >= 0: sum += self.grid[i-1][j]
                    if i+1 < self.m: sum += self.grid[i+1][j]
                    if j-1 >= 0: sum += self.grid[i][j-1]
                    if j+1 < self.n: sum += self.grid[i][j+1]
                    return sum
        return 0
        

    def diagonalSum(self, value: int) -> int:
        for i in range(self.m):
            for j in range(self.n):
                if self.grid[i][j] == value:
                    sum = 0
                    if i-1 >= 0 and j-1 >= 0: sum += self.grid[i-1][j-1]
                    if i-1 >= 0 and j+1 < self.n: sum += self.grid[i-1][j+1]
                    if i+1 < self.m and j-1 >= 0: sum += self.grid[i+1][j-1]
                    if i+1 < self.m and j+1 < self.n: sum += self.grid[i+1][j+1]
                    return sum
        return 0
        


# Your neighborSum object will be instantiated and called as such:
# obj = neighborSum(grid)
# param_1 = obj.adjacentSum(value)
# param_2 = obj.diagonalSum(value)