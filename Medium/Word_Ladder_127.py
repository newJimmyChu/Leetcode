from collections import deque
class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
    	if endWord not in wordList:
    		return 0
        char_set = [set() for elem in list(wordList[0])]
        for i in range(len(char_set)):
        	for elem in wordList:
        		if elem[i] not in char_set[i]:
        			char_set[i].add(elem[i])
       	q = deque()
       	wordList = set(wordList)
       	visited = set()
       	visited.add(beginWord)
       	q.append((1, beginWord))
       	while len(q) > 0:
       		frontier = q.popleft()
       		if ''.join(frontier[1]) == endWord:
       			return frontier[0]
       		successors(frontier[1], frontier[0], q, visited, char_set, wordList)
        return 0

def successors(frontier, level, q, visited, char_set, wordList):
	for i, char in enumerate(frontier):
		for target in char_set[i]:
			if char != target:
				s = [c for c in frontier]
				s[i] = target
				s = ''.join(s)
				if s in wordList:
					wordList.remove(s)
					q.append((level + 1, s))