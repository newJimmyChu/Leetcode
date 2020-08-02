class Solution(object):
    def letterCombinations(self, digits):
    	if len(digits) == 0:
    		return []
    	digits_dict = {'2': "abc", '3': "def", '4': "ghi", '5': "jkl", '6': "mno", '7': "pqrs", '8': "tuv", '9': "wxyz"}
        return list(bfs("", digits, len(digits), digits_dict))


def bfs(letter, digits, level, digits_dict):
	n = digits[len(letter)]
	if level == 1:
		for l in digits_dict[n]:
			yield letter + l
	elif level > 1:
		for l in digits_dict[n]:
			for elem in bfs(letter + l, digits, level - 1, digits_dict):
				yield elem