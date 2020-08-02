import math

class Solution(object):
    def numSquares(self, n):
        q = []
        squares = [elem**2 for elem in range(1, int(math.sqrt(n))+1)]
        visited = set()
        squares = set(squares)
        q.append((0, n))
        while len(q) > 0:
        	frontier = q.pop(0)
        	if frontier[1] == 0:
        		return frontier[0]
        	Successors(frontier[1], q, squares, frontier[0], visited)
        return None


def Successors(num, q, squares, level, visited):
	for elem in squares:
		s = num - elem
		if s >= 0:
			if s not in visited:
				q.append((level + 1, s))
				visited.add(s)