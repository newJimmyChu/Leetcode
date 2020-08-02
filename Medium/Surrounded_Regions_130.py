class Solution(object):
    def solve(self, board):
    	if board == [] or board == [[]]:
    		return
    	for i in range(len(board)):
    		dfs(board, i, 0)
    		dfs(board, i, len(board[0])-1)
    	for j in range(len(board[0])):
    		dfs(board, 0, j)
    		dfs(board, len(board)-1, j)
    	for i in range(len(board)):
    		for j in range(len(board[0])):
    			if board[i][j] == 'T':
    				board[i][j] = 'O'
    			else:
    				board[i][j] = 'X'

def dfs(board, i, j):
	if i < 0 or i >= len(board) or j < 0 or j >= len(board[0]) or board[i][j] != 'O':
		return
	board[i][j] = 'T'
	dfs(board, i - 1, j)
	dfs(board, i + 1, j)
	dfs(board, i, j - 1)
	dfs(board, i, j + 1)
	return





class Solution(object):
    def solve(self, board):
    	o_list = []
    	r = []
    	directions = [(-1, 0), (0, -1), (1, 0), (0, 1)]
    	for i in range(len(board)):
    		for j in range(len(board[0])):
    			if board[i][j] == 'O':
    				o_list.append((i, j))
    	while len(o_list) > 0:
    		frontier = o_list.pop(0)
    		successor(board, frontier[0], frontier[1], directions, o_list, r)
    	while len(r) > 0:
    		frontier = r.pop(0)
    		successor(board, frontier[0], frontier[1], directions, o_list, r)

def successor(board, i, j, directions, q, r):
	t = True
	if board[i][j] == 'X':
		for d in directions:
			if board[i + d[0]][j + d[1]] == 'O':
				if (i, j) in r:
					r.remove((i, j))
				board[i][j] = 'O'
		return False
	succ = True
	board[i][j] = 'X'
	for d in directions:
		if i + d[0] < 0 or i + d[0] >= len(board) or j + d[1] < 0 or j + d[1] >= len(board[0]):
			board[i][j] = 'O'
			if (i, j) in q:
				q.remove((i, j))
			return False
	for d in directions:
		if board[i + d[0]][j + d[1]] == 'O':
			t = False
			succ = succ and successor(board, i + d[0], j + d[1], directions, q, r)
	if succ:
		if t:
			r.append((i, j))
		elif (i,j) in q:
			q.remove((i, j))
		return True
	board[i][j] = 'O'
	if (i, j) in q:
		q.remove((i, j))
	return False


[["X","X","X","X","O","O","X","X","O"],
["O","O","O","O","X","X","O","O","X"],
["X","O","X","O","O","X","X","O","X"],
["O","O","X","X","X","O","O","O","O"],
["X","O","O","X","X","X","X","X","O"],
["O","O","X","O","X","O","X","O","X"],
["O","O","O","X","X","O","X","O","X"],
["O","O","O","X","O","O","O","X","O"],
["O","X","O","O","O","X","O","X","O"]]



[["X","X","X","X","O","O","X","X","O"],
["O","O","O","O","X","X","O","O","X"],
["X","O","X","O","O","X","X","O","X"],
["O","O","X","X","X","X","X","O","O"],
["X","O","O","X","X","X","X","X","O"],
["O","O","X","X","X","X","X","X","X"],
["O","O","O","X","X","X","X","X","X"],
["O","O","O","X","O","O","O","X","O"],
["O","X","O","O","O","X","O","X","O"]]

[["X","X","X","X","O","O","X","X","O"],
["O","O","O","O","X","X","O","O","X"],
["X","O","X","O","O","X","X","O","X"],
["O","O","X","X","X","O","O","O","O"],
["X","O","O","X","X","X","X","X","O"],
["O","O","X","X","X","O","X","X","X"],
["O","O","O","X","X","O","X","X","X"],
["O","O","O","X","O","O","O","X","O"],
["O","X","O","O","O","X","O","X","O"]]






[["X","O","X","O","O","O","O"],
["X","O","O","O","O","O","O"],
["X","O","O","O","O","X","O"],
["O","O","O","O","X","X","X"],
["O","X","O","O","O","O","O"],
["O","O","O","O","O","O","O"],
["O","X","O","O","O","O","O"]]

[["X","O","X","O","O","O","O"],
["X","O","O","O","O","O","O"],
["X","O","O","O","O","X","O"],
["O","O","O","O","X","O","X"],
["O","X","O","O","O","O","O"],
["O","O","O","O","O","O","O"],
["O","X","O","O","O","O","O"]]