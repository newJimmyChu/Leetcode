class Solution(object):
    def reverseVowels(self, s):
        vowels = set(['a','e','i','o','u','A','E','I','O','U'])
        index = 0;
        vowel_list = []
        ls = [char for char in s]
        for char in s:
        	if char in vowels:
        		vowel_list.append(index)
        	index += 1
        i, j = 0, len(vowel_list) - 1
        while i < j:
        	temp = ls[vowel_list[i]]
        	ls[vowel_list[i]] = ls[vowel_list[j]]
        	ls[vowel_list[j]] = temp
        	i += 1
        	j -= 1
        return ''.join(ls)
