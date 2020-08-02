class Solution(object):
    def maxProfit(self, prices):
    	if prices == []:
    		return 0
        max_pro = 0
        for index, elem in enumerate(prices):
        	if prices[index+1:] == []:
        		return max_pro
        	t = max(prices[index+1:]) - elem
        	if max_pro < t:
        		max_pro = t
        return max_pro