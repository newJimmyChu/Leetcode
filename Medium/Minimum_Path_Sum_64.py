import heapq

class Solution(object):
    def minPathSum(self, grid):
        if grid == [] or grid == [[]]:
            return 0
        q = []
        visited = set()
        visited.add((0,0))
        heappush(q, (grid[0][0], (0, 0)))
        directions = [(0, -1), (-1, 0), (1, 0), (0, 1)]
        while len(q) > 0:
            frontier = heappop(q)
            if frontier[1] == (len(grid) - 1, len(grid[0]) - 1):
                return frontier[0]
            successors(grid, frontier[1][0], frontier[1][1], frontier[0], directions, q, visited)
        return 0


def successors(grid, x, y, prevValue, directions, q, visited):
    for i, j in directions:
        if x + i < 0 or x + i >= len(grid) or y + j < 0 or y + j >= len(grid[0]):
            continue
        if (x + i, y + j) not in visited:
            visited.add((x + i, y + j))
            heappush(q, (prevValue + grid[x+i][y+j], (x + i, y + j)))




class Solution(object):
    def minPathSum(self, grid):
        if grid == [] or grid == [[]]:
            return 0
        if len(grid) == 1 and len(grid[0]) == 1:
            return grid[0][0]
        dp = [[0 for x in grid[0]] for y in grid]
        dp[0][0] = grid[0][0]
        for i in range(0, len(grid)):
            for j in range(0, len(grid[0])):
                if i == 0:
                    dp[0][j] = dp[0][j - 1] + grid[0][j]
                elif j == 0:
                    dp[i][0] = dp[i - 1][0] + grid[i][0]
                elif i != 0 and j != 0:
                    dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
        return dp[len(grid) - 1][len(grid[0]) - 1]


