class Solution(object):
    def findLongestWord(self, s, d):
    	in_str = [char for char in s]
    	ret_list = []
    	word_ptr = 0
        for word in d:
        	word_ptr = 0
        	for char in in_str:
        		if char == word[word_ptr]:
        			word_ptr += 1
        		if word_ptr >= len(word):
        			ret_list.append(word)
        			break
        if ret_list == []:
        	return None
        largest_str = max(ret_list, key=lambda x: len(x))
        largest_list = list([elem for elem in ret_list if len(elem) == len(largest_str)])
        print(largest_str)
        return sorted(largest_list[0])
        