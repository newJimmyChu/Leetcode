import re

class Solution(object):
    def isPalindrome(self, s):
        st = [char.lower() for char in s if char.isalpha() or char.isnumeric()]
        i, j = 0, len(st) - 1
        while i < j:
        	if st[i] != st[j]:
        		return False
        	i += 1
        	j -= 1
       	return True
