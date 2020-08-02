class Solution(object):
	def findContentChildren(self, g, s):
		s.sort()
		counter = 0
		for cookie in s:
			if len(g) == 0:
				return counter
			if cookie in g:
				g.remove(cookie)
				counter += 1
			else:
				min_val = float("inf")
				for elem in g:
					if elem <= cookie and elem < min_val:
						min_val = elem
				if min_val != None and min_val != float("inf"):
					g.remove(min_val)
					counter += 1
		return counter
