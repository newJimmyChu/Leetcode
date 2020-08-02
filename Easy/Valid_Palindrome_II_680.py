class Solution(object):
	def validPalindrome(self, s):
		st = [char for char in s if char.isalpha()]
		i, j = 0, len(st) - 1
		rec_i, rec_j = 0, 0
		flag = 0
		while i <= j:
			if st[i] != st[j] and flag == 0:
				if self.isPAlindrome(i + 1, j, st):
					return True
				else:
					flag = flag + 1
					continue
			elif st[i] != st[j] and flag == 1:
				return self.isPAlindrome(i, j - 1, st)
			i += 1
			j -= 1
		return True

	def isPAlindrome(self, i, j, s):
		while i <= j:
			if s[i] != s[j]:
				return False
			i += 1
			j -= 1
		return True
