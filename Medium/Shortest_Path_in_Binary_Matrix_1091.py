import heapq
import math

class Solution(object):
    def shortestPathBinaryMatrix(self, grid):
    	directions = [(-1,-1),(-1,0),(0,-1),(0,1),(1,0),(1,-1),(-1,1),(1,1)]
        q = []
        heapq.heappush(q, (1, (0, 0)))
        vs = set()
        vs.add((0, 0))
        if grid[0][0] == 1 or grid[len(grid[0])-1][len(grid[0])-1] == 1:
        	return -1
        while len(q) > 0:
        	frontier = heapq.heappop(q)
            print("aaaaaaaa")
        	x, y = frontier[1][0], frontier[1][1]
        	if frontier[1] == (len(grid[0])-1, len(grid[0])-1):
        		return frontier[0]
			for d in directions:
				if x + d[0] < 0 or x + d[0] >= len(grid[0]) or y + d[1] < 0 or y + d[1] >= len(grid[0]):
					continue
				else:
					print(q)
					if grid[x + d[0]][y + d[1]] == 0 and (x+d[0],y+d[1]) not in vs:
						vs.add((x + d[0], y + d[1]))
						heapq.heappush(q, (frontier[0] + 1, (x + d[0], y + d[1])))
        return -1







def Successor(grid, point, g_queue, prev_val, directions, vs):
	x, y = point[0], point[1]
	for d in directions:
		if x + d[0] < 0 or x + d[0] >= len(grid[0]) or y + d[1] < 0 or y + d[1] >= len(grid[0]):
			continue
		else:
			if grid[x + d[0]][y + d[1]] == 0 and (x+d[0],y+d[1]) not in vs:
				vs.add((x + d[0], y + d[1]))
				heapq.heappush(g_queue, (prev_val + 1, (x + d[0], y + d[1])))
	