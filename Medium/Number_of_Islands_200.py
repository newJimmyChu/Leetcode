from collections import deque
class Solution(object):
    def numIslands(self, grid):
    	grid = [[x for x in y] for y in grid]
    	directions = [(-1, 0), (0, -1), (1, 0), (0, 1)]
    	k = 0
        q = deque()
        for i in range(len(grid)):
        	for j in range(len(grid[0])):
        		if grid[i][j] == '1':
        			q.append((i, j))
        			while len(q) > 0:
        				frontier = q.popleft()
        				successors(grid, frontier[0], frontier[1], q, directions)
        			k += 1
    	return k

def successors(grid, i, j, q, directions):
	if grid[i][j] == '0':
		return
	grid[i][j] = '0'
	for x, y in directions:
		if i + x >= 0 and i + x < len(grid) and j + y >= 0 and j + y < len(grid[0]):
			if grid[i + x][j + y] == '1':
				q.append((i + x, j + y))