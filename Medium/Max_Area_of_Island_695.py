from collections import deque

class Solution(object):
    def maxAreaOfIsland(self, grid):
    	directions = [(-1, 0), (0, -1), (1, 0), (0, 1)]
    	q = deque()
    	max_val = 0
    	k = [0]
    	for i in range(len(grid)):
    		for j in range(len(grid[0])):
    			if grid[i][j] == 1:
    				q.append((i, j))
    				while len(q) > 0:
    					frontier = q.popleft()
    					successors(grid, frontier[0], frontier[1], q, directions, k)
    				if k[0] > max_val:
    					max_val = k[0]
    				k[0] = 0
    	return max_val


def successors(grid, i, j, q, directions, k):
	if grid[i][j] == 0:
		return
	k[0] += 1
	grid[i][j] = 0
	for (x, y) in directions:
		if i + x >= 0 and i + x < len(grid) and j + y >= 0 and j + y < len(grid[0]):
			if grid[i + x][j + y] == 1:
				q.append((i + x, j + y))