class Solution(object):
    def partitionLabels(self, S):
    	i, j, k, count = 0, 0, 0, 0
    	char_set = set()
    	s = [c for c in S]
    	ret_list = []
    	while i < len(S):
    		count += 1
    		if s[i] not in char_set:
    			char_set.add(s[i])
    			for j in range(i, len(s)):
    				if s[j] == s[i]:
    					if j > k:
    						k = j
    		if i == k:
    			ret_list.append(count)
    			count = 0
    			i += 1
    			continue
    		i += 1
    	return ret_list



        """
        :type S: str
        :rtype: List[int]
        """