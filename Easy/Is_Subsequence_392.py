class Solution(object):
    def isSubsequence(self, s, t):
        i, j = 0, 0
        new_s = list(s)
        new_t = list(t)
        while i < len(new_s) and j < len(new_t):
        	if new_s[i] == new_t[j]:
        		i += 1
        		j += 1
        	else:
        		j += 1
        if i == len(new_s):
        	return True
        return False